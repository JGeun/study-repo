package com.jgeun.fastcampus.sns.data.database

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.jgeun.fastcampus.sns.data.model.BoardDTO
import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import javax.inject.Inject

/**
 * @author   JGeun
 * @created  2025/02/23
 */
@OptIn(ExperimentalPagingApi::class)
class BoardRemoteMediator @Inject constructor(
	private val boardService: BoardService,
	private val boardDatabase: BoardDatabase
): RemoteMediator<Int, BoardDTO>() {

	private val remoteKeyDao = boardDatabase.remoteKeyDao()
	private val boardDao = boardDatabase.boardDao()

	override suspend fun load(
		loadType: LoadType,
		state: PagingState<Int, BoardDTO>
	): MediatorResult {

		val remoteKey = when(loadType) {
			LoadType.REFRESH -> { null }
			LoadType.PREPEND -> { return MediatorResult.Success(endOfPaginationReached = true) }
			LoadType.APPEND -> { remoteKeyDao.getNextKey() }
		}

		try {
			val page = remoteKey ?.nextPage ?: 1
			val loadSize = 10
			val response = boardService.getBoards(
				page = page,
				size = loadSize
			)
			val boardList = response.data
			boardDatabase.withTransaction {
				if (loadType == LoadType.REFRESH) {
					boardDao.deleteAll()
					remoteKeyDao.deleteAll()
				}

				remoteKeyDao.insertOrReplace(RemoteKey(nextPage = page + 1))
				boardDao.insertAll(boardList)
			}
			return MediatorResult.Success(loadSize != boardList.size)
		} catch (e: Exception) {
			return MediatorResult.Error(e)
		}
	}
}