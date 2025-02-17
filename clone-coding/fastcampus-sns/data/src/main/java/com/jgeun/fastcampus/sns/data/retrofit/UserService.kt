package com.jgeun.fastcampus.sns.data.retrofit

import com.jgeun.fastcampus.sns.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 *
 * @author   JGeun
 * @created  2025/02/17
 */
interface UserService {

	@POST("users/login")
	@Headers("Content-Type: application/json; charset=UTF8")
	suspend fun login(
		@Body requestBody: RequestBody
	): CommonResponse<String>
}