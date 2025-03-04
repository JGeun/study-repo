package com.jgeun.fastcampus.sns.data.usecase.main.writing

import android.app.Notification
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.jgeun.fastcampus.sns.data.model.BoardParam
import com.jgeun.fastcampus.sns.data.model.BoardParcel
import com.jgeun.fastcampus.sns.data.model.ContentParam
import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import com.jgeun.fastcampus.sns.data.service.PostingService
import com.jgeun.fastcampus.sns.domain.model.ACTION_POSTED
import com.jgeun.fastcampus.sns.domain.usecase.file.UploadImageUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.serialization.json.Json

/**
 * @author   JGeun
 * @created  2025/03/01
 */
@HiltWorker
class BoardWorker @AssistedInject constructor(
	@Assisted private val appContext: Context,
	@Assisted private val params: WorkerParameters,
	private val boardService: BoardService,
	private val uploadImageUseCase: UploadImageUseCase
): CoroutineWorker(appContext, params) {
	override suspend fun doWork(): Result {
		val boardParcelJson = inputData.getString(BoardParcel::class.java.simpleName) ?: return Result.failure()
		val boardParcel = Json.decodeFromString<BoardParcel>(boardParcelJson)
		postBoard(boardParcel)
		return Result.success()
	}

	override suspend fun getForegroundInfo(): ForegroundInfo {
		return ForegroundInfo(
			PostingService.FOREGROUND_NOTIFICATION_ID,
			createNotification()
		)
	}

	private fun createNotification(): Notification {
		return NotificationCompat.Builder(appContext, PostingService.CHANNEL_ID).build()
	}

	private suspend fun postBoard(boardParcel: BoardParcel) {
		// 업로드
		val uploadedImages = boardParcel.images.mapNotNull { image ->
			uploadImageUseCase(image).getOrNull()
		}

		val content = ContentParam(
			text = boardParcel.content,
			images = uploadedImages
		)

		val boardParam = BoardParam(boardParcel.title, content.toJson())
		boardService.postBoard(boardParam.toRequestBody())
		appContext.sendBroadcast(
			Intent(
				ACTION_POSTED
			).apply {
				setPackage(appContext.packageName)
			}
		)
	}
}