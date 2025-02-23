package com.jgeun.fastcampus.sns.data.usecase.main.board

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.jgeun.fastcampus.sns.data.database.BoardDatabase
import com.jgeun.fastcampus.sns.data.database.BoardRemoteMediator
import com.jgeun.fastcampus.sns.data.model.toDomainModel
import com.jgeun.fastcampus.sns.domain.model.Board
import com.jgeun.fastcampus.sns.domain.usecase.main.board.GetBoardsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
class GetBoardsUseCaseImpl @Inject constructor(
	private val boardDatabase: BoardDatabase,
	private val mediator: BoardRemoteMediator,
) : GetBoardsUseCase {

	@OptIn(ExperimentalPagingApi::class)
	override suspend fun invoke(): Result<Flow<PagingData<Board>>> = runCatching {
		Pager(
			config = PagingConfig(
				pageSize = 10,
				initialLoadSize = 10
			),
			remoteMediator = mediator,
			pagingSourceFactory = {
				boardDatabase.boardDao().getAll()
			},
		).flow.map { pagingData ->
			pagingData.map { it.toDomainModel() }
		}
	}
}