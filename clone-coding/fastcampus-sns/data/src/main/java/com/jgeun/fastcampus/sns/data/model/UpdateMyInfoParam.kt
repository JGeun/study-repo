package com.jgeun.fastcampus.sns.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Serializable
data class UpdateMyInfoParam(
	val userName: String,
	val extraUserInfo: String,
	val profileFilePath: String
) {
	fun toRequestBody(): RequestBody {
		return Json.encodeToString(this).toRequestBody()
	}
}