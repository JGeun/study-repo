package com.jgeun.fastcampus.sns.data.usecase.main.board

import com.jgeun.fastcampus.sns.data.model.CommentParam
import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import com.jgeun.fastcampus.sns.domain.usecase.main.board.PostCommentUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
class PostCommentUseCaseImpl @Inject constructor(
	private val boardService: BoardService
) : PostCommentUseCase {
	override suspend fun invoke(boardId: Long, text: String): Result<Long> = kotlin.runCatching {
		val requestBody = CommentParam(text).toRequestBody()
		boardService.postComment(
			boardId = boardId,
			requestBody = requestBody
		).data
	}
}