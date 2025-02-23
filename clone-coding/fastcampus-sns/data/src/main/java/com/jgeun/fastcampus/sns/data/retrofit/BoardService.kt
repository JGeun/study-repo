package com.jgeun.fastcampus.sns.data.retrofit

import com.jgeun.fastcampus.sns.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface BoardService {

	@POST("boards")
	suspend fun postBoard(
		@Body requestBody: RequestBody
	): CommonResponse<Long>
}