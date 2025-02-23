package com.jgeun.fastcampus.sns.domain.model

import kotlinx.serialization.Serializable

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */

@Serializable
data class Image(
	val uri: String,
	val name: String,
	val size: Long,
	val mimeType: String
): java.io.Serializable