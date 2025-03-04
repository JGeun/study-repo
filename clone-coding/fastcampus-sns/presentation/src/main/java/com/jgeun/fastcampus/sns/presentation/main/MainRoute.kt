package com.jgeun.fastcampus.sns.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
enum class MainRoute(
	val route: String,
	val contentDescription: String,
	val icon: ImageVector
) {
	BOARD("BoardScreen", "글목록", Icons.Filled.Home),
	WRITING("WritingScreen", "글쓰기", Icons.Filled.AddCircle),
	SETTING("SettingScreen", "내 정보", Icons.Filled.AccountCircle)
}