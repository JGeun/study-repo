package com.jgeun.fastcampus.sns.data.retrofit

import com.jgeun.fastcampus.sns.data.model.CommonResponse
import com.jgeun.fastcampus.sns.data.model.FileDTO
import okhttp3.MultipartBody
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface FileService {

	@POST("files")
	@Multipart
	@Headers("ContentType: multipart/form-data;")
	suspend fun uploadFile(
		@Part fileName:MultipartBody.Part,
		@Part file:MultipartBody.Part
	): CommonResponse<FileDTO>
}