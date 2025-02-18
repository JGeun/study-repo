package com.jgeun.fastcampus.sns.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
@Serializable
data class SignUpParam(
	val loginId: String,
	val name: String,
	val password: String,
	val extraUserInfo: String,
	val  profileFilePath: String
) {
	fun toRequestBody(): RequestBody {
		return Json.encodeToString(this).toRequestBody()
	}
}