package com.jgeun.fastcampus.sns.data.model

import com.jgeun.fastcampus.sns.domain.model.Board
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Serializable
data class BoardDTO(
	val id: Long,
	val title: String,
	val content: String,
	val createdAt: String,
	val updatedAt: String,
	val createUserId: Long,
	val createUserName: String,
	val createUserProfileFilePath: String,
	val commentList:List<CommentDTO>
)

fun BoardDTO.toDomainModel(): Board {
	val contentParam = Json.decodeFromString<ContentParam>(content)
	return Board(
		userId = this.createUserId,
		id = this.id,
		title = this.title,
		content = contentParam.text,
		images = contentParam.images,
		username = this.createUserName,
		profileImageUrl = this.createUserProfileFilePath,
		comments = this.commentList.map { it.toDomainModel() }
	)
}