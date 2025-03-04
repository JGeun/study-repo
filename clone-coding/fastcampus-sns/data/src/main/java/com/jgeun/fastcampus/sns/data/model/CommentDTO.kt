package com.jgeun.fastcampus.sns.data.model

import com.jgeun.fastcampus.sns.domain.model.Comment
import kotlinx.serialization.Serializable

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Serializable
data class CommentDTO(
	val id: Long,
	val comment: String,
	val createdAt: String,
	val createUserId: Long,
	val createUserName: String,
	val profileImageUrl: String
)

fun CommentDTO.toDomainModel(): Comment {
	return Comment(
		id = id,
		text = comment,
		username = createUserName,
		profileImageUrl = profileImageUrl
	)
}