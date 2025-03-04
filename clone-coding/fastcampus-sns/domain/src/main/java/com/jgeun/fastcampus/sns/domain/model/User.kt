package com.jgeun.fastcampus.sns.domain.model

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
data class User(
	val id: Long,
	val loginId: String,
	val username: String,
	val profileImageUrl: String? = null
)