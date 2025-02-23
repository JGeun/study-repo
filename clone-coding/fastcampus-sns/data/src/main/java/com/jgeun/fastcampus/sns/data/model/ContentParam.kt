package com.jgeun.fastcampus.sns.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Serializable
data class ContentParam(
	val text: String,
	val images: List<String>
) {
	fun toJson(): String {
		return Json.encodeToString(this)
	}
}