package com.jgeun.fastcampus.sns.domain.model

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
data class Comment(
	val id: Long,
	val text: String,
	val username: String,
	val profileImageUrl: String? = null
)