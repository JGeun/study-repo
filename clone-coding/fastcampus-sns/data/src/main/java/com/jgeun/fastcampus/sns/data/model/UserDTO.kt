package com.jgeun.fastcampus.sns.data.model

import com.jgeun.fastcampus.sns.domain.model.User
import kotlinx.serialization.Serializable

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Serializable
data class UserDTO(
	val id: Long,
	val loginId: String,
	val userName: String,
	val extraUserInfo: String,
	val profileFilePath: String
)

fun UserDTO.toDomainModel(): User {
	return User(
		id = this.id,
		loginId = this.loginId,
		username = this.userName,
		profileImageUrl = this.profileFilePath
	)
}