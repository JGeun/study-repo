package com.jgeun.fastcampus.sns.data.usecase.main.writing

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.jgeun.fastcampus.sns.data.model.BoardParcel
import com.jgeun.fastcampus.sns.domain.model.Image
import com.jgeun.fastcampus.sns.domain.usecase.main.writing.PostBoardUseCase
import kotlinx.serialization.json.Json
import javax.inject.Inject

/**
 * @author   JGeun
 * @created  2025/03/01
 */
class HiltWorkerPostBoardUseCase @Inject constructor(
	private val context: Context
) : PostBoardUseCase {

	override suspend fun invoke(title: String, content: String, images: List<Image>) {
		val boardParcel = BoardParcel(
			title = title,
			content = content,
			images = images
		)

		val boardParcelJson = Json.encodeToString(boardParcel)

		val workRequest = OneTimeWorkRequestBuilder<BoardWorker>()
			.setInputData(
				workDataOf(
					BoardParcel::class.java.simpleName to boardParcelJson
				)
			)
			.build()

		WorkManager.getInstance(context).enqueue(workRequest)
	}
}