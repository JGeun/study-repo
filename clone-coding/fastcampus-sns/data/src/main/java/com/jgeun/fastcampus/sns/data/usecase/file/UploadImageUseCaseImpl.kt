package com.jgeun.fastcampus.sns.data.usecase.file

import com.jgeun.fastcampus.sns.data.constant.FC_HOST
import com.jgeun.fastcampus.sns.data.retrofit.FileService
import com.jgeun.fastcampus.sns.data.retrofit.UriRequestBody
import com.jgeun.fastcampus.sns.domain.model.Image
import com.jgeun.fastcampus.sns.domain.usecase.file.GetInputStreamUseCase
import com.jgeun.fastcampus.sns.domain.usecase.file.UploadImageUseCase
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
class UploadImageUseCaseImpl @Inject constructor(
	private val fileService: FileService,
	private val getInputStreamUseCase: GetInputStreamUseCase
) : UploadImageUseCase {

	override suspend fun invoke(image: Image): Result<String> = runCatching {
		val fileNamePart = MultipartBody.Part.createFormData(
			name = "fileName",
			value = image.name
		)

		val requestBody = UriRequestBody(
			contentUri = image.uri,
			getInputStreamUseCase = getInputStreamUseCase,
			contentType = image.mimeType.toMediaType(),
			contentLength = image.size
		)

		val filePart = MultipartBody.Part.createFormData(
			"file",
			 image.name,
			requestBody
		)

		val uploadFilePath = fileService.uploadFile(
			fileName = fileNamePart,
			file = filePart
		).data.filePath

		if (uploadFilePath.firstOrNull() == '/') {
			FC_HOST + uploadFilePath
		} else {
			FC_HOST + "/${uploadFilePath}"
		}
	}
}