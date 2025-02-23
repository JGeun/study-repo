package com.jgeun.fastcampus.sns.domain.usecase.main.board

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface PostCommentUseCase {

	suspend operator fun invoke(
		boardId: Long,
		text: String
	): Result<Long>
}