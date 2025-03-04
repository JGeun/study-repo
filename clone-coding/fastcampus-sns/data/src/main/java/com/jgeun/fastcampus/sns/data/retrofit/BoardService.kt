package com.jgeun.fastcampus.sns.data.retrofit

import com.jgeun.fastcampus.sns.data.model.BoardDTO
import com.jgeun.fastcampus.sns.data.model.CommonResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface BoardService {

	@GET("boards")
	suspend fun getBoards(
		@Query("page") page: Int,
		@Query("size") size: Int
	): CommonResponse<List<BoardDTO>>

	@POST("boards")
	suspend fun postBoard(
		@Body requestBody: RequestBody
	): CommonResponse<Long>


	@DELETE("boards/{id}")
	suspend fun deleteBoard(
		@Path("id") id: Long
	): CommonResponse<Long>

	@POST("boards/{id}/comments")
	suspend fun postComment(
		@Path("id") boardId: Long,
		@Body requestBody: RequestBody
	): CommonResponse<Long>

	@DELETE("boards/{boardId}/comments/{commentId}")
	suspend fun deleteComment(
		@Path("boardId") boardId: Long,
		@Path("commentId") commentId: Long,
	): CommonResponse<Long>
}