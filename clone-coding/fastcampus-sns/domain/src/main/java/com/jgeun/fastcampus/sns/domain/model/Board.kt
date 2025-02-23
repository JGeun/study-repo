package com.jgeun.fastcampus.sns.domain.model

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
data class Board(
	val userId: Long,
	val id: Long,
	val title: String,
	val content: String,
	val images: List<String>,
	val username: String,
	val profileImageUrl: String,
	val comments:List<Comment>
)