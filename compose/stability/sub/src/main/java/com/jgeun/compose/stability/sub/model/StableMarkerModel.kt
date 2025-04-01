package com.jgeun.compose.stability.sub.model

import androidx.compose.runtime.Stable

/**
 *
 * @author   JGeun
 * @created  2025/04/01
 */
@Stable
data class StableMarkerModel(
    val name: String,
    val age: Int
)