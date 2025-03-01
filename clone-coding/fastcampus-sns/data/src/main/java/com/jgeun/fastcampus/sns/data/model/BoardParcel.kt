package com.jgeun.fastcampus.sns.data.model

import android.os.Parcelable
import com.jgeun.fastcampus.sns.domain.model.Image
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Parcelize
@Serializable
data class BoardParcel(
	val title: String,
	val content: String,
	val images: List<Image>
) : Parcelable