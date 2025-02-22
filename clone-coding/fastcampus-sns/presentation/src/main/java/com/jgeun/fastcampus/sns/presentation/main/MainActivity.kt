package com.jgeun.fastcampus.sns.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jgeun.fastcampus.sns.presentation.theme.ConnectedTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			ConnectedTheme {
				MainNavHost()
			}
		}
	}
}