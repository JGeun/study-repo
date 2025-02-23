package com.jgeun.fastcampus.sns.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jgeun.fastcampus.sns.presentation.R
import com.jgeun.fastcampus.sns.presentation.main.board.BoardScreen
import com.jgeun.fastcampus.sns.presentation.main.board.BoardViewModel
import com.jgeun.fastcampus.sns.presentation.main.setting.SettingScreen

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost(
	boardViewModel: BoardViewModel
) {
	val navController = rememberNavController()

	Surface {
		Scaffold(
			topBar = {
				TopAppBar(
					modifier = Modifier.background(MaterialTheme.colorScheme.background),
					title = {
						Text(text = stringResource(R.string.app_name))
					},
				)
			},
			content = { padding ->
				NavHost(
					modifier = Modifier.padding(padding),
					navController = navController,
					startDestination = MainRoute.BOARD.route
				) {
					composable(MainRoute.BOARD.route) {
						BoardScreen(boardViewModel)
					}

					composable(MainRoute.SETTING.route) {
						SettingScreen()
					}
				}
			},
			bottomBar = {
				MainBottomBar(
					navController = navController
				)
			}
		)
	}
}