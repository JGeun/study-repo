package com.jgeun.fastcampus.sns.data.usecase.main.board

import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import com.jgeun.fastcampus.sns.domain.usecase.main.board.DeleteCommentUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
class DeleteCommentUseCaseImpl @Inject constructor(
	private val boardService: BoardService
) : DeleteCommentUseCase {
	override suspend fun invoke(boardId: Long, commentId: Long): Result<Long> = kotlin.runCatching{
		boardService.deleteComment(
			boardId = boardId,
			commentId = commentId
		).data
	}
}