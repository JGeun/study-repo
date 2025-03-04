package com.jgeun.fastcampus.sns.domain.usecase.main.board

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface DeleteCommentUseCase {

	suspend operator fun invoke(
		boardId:Long,
		commentId:Long
	):Result<Long>
}