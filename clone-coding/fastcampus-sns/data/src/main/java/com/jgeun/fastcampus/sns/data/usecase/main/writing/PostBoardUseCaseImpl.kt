package com.jgeun.fastcampus.sns.data.usecase.main.writing

import android.content.Context
import android.content.Intent
import com.jgeun.fastcampus.sns.data.model.BoardParcel
import com.jgeun.fastcampus.sns.data.service.PostingService
import com.jgeun.fastcampus.sns.domain.model.Image
import com.jgeun.fastcampus.sns.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
class PostBoardUseCaseImpl @Inject constructor(
	private val context: Context
) : PostBoardUseCase {

	override suspend fun invoke(
		title: String,
		content: String,
		images: List<Image>
	) {
		val board = BoardParcel(title = title, content = content, images = images)
		context.startForegroundService(
			Intent(
				context,
				PostingService::class.java
			).apply {
				putExtra(PostingService.EXTRA_BOARD, board)
			}
		)

	}
}