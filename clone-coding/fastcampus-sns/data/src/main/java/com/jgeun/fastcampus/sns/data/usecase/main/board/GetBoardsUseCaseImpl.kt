package com.jgeun.fastcampus.sns.data.usecase.main.board

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import com.jgeun.fastcampus.sns.domain.model.Board
import com.jgeun.fastcampus.sns.domain.usecase.main.board.GetBoardsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Provider

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
class GetBoardsUseCaseImpl @Inject constructor(
	private val pagingSource: Provider<BoardPagingSource>
) : GetBoardsUseCase {

	override suspend fun invoke(): Result<Flow<PagingData<Board>>> = runCatching {
		 Pager(
			config = PagingConfig(
				pageSize = 10,
				initialLoadSize = 10
			),
			pagingSourceFactory = { pagingSource.get() }
		).flow
	}
}