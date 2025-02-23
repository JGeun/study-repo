package com.jgeun.fastcampus.sns.presentation.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.jgeun.fastcampus.sns.domain.model.ACTION_POSTED
import com.jgeun.fastcampus.sns.presentation.main.board.BoardViewModel
import com.jgeun.fastcampus.sns.presentation.theme.ConnectedTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	private val boardViewModel: BoardViewModel by viewModels()

	private val receiver = object : BroadcastReceiver() {
		override fun onReceive(context: Context?, intent: Intent?) {
			if (intent?.action == ACTION_POSTED) {
				boardViewModel.load()
			}
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			ConnectedTheme {
				MainNavHost(
					boardViewModel = boardViewModel
				)
			}
		}

		ContextCompat.registerReceiver(
			this,
			receiver,
			IntentFilter(ACTION_POSTED),
			ContextCompat.RECEIVER_NOT_EXPORTED
		)
	}

	override fun onDestroy() {
		super.onDestroy()
		unregisterReceiver(receiver)
	}
}