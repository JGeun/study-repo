package com.jgeun.fastcampus.sns.presentation.main.writing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jgeun.fastcampus.sns.presentation.theme.ConnectedTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@AndroidEntryPoint
class WritingActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			ConnectedTheme {
				WritingNavHost{ finish() }
			}
		}
	}
}