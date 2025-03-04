package com.jgeun.fastcampus.sns.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Serializable
data class BoardParam(
	val title: String,
	val content: String
) {
	fun toRequestBody(): RequestBody {
		return Json.encodeToString(this).toRequestBody()
	}
}