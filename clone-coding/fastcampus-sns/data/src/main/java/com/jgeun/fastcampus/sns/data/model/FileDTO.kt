package com.jgeun.fastcampus.sns.data.model

import kotlinx.serialization.Serializable

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Serializable
data class FileDTO(
	val id: Long,
	val fileName: String,
	val createdAt: String,
	val filePath: String
)