package com.jgeun.fastcampus.sns.data.model

import kotlinx.serialization.Serializable

/**
 *
 * @author   JGeun
 * @created  2025/02/17
 */
@Serializable
data class CommonResponse<T>(
	val result: String,
	val data: T,
	val errorCode: String,
	val errorMessage: String,
)