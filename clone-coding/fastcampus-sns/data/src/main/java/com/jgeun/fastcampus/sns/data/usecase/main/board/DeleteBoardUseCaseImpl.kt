package com.jgeun.fastcampus.sns.data.usecase.main.board

import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import com.jgeun.fastcampus.sns.domain.usecase.main.board.DeleteBoardUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
class DeleteBoardUseCaseImpl @Inject constructor(
	private val boardService: BoardService
) : DeleteBoardUseCase {

	override suspend fun invoke(boardId: Long): Result<Long> = runCatching {
		boardService.deleteBoard(boardId).data
	}
}