package com.jgeun.fastcampus.sns.presentation.main.board

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jgeun.fastcampus.sns.presentation.main.setting.SettingScreen

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Composable
fun BoardScreen(

) {
	Text(text = "BoardScreen")
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardScreenPreview() {
	BoardScreen()
}