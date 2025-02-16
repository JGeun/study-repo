package com.jgeun.fastcampus.sns.presentation.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
@Composable
fun LoginNavHost() {

	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = LoginRoute.WelcomeScreen.name
	) {
		composable(
			route = LoginRoute.WelcomeScreen.name
		) {
			WelcomeScreen(
				onNavigateToLoginScreen = {
					navController.navigate(route = LoginRoute.LoginScreen.name)
				}
			)
		}

		composable(
			route = LoginRoute.LoginScreen.name
		) {
			LoginScreen()
		}

		composable(
			route = LoginRoute.SignUpScreen.name
		) {
			SignUpScreen(
				id = "lorem",
				userName = "Denny Crawford",
				password1 = "expetendis",
				password2 = "animal",
				onIdChange = {},
				onUserNameChange = {},
				onPassword1Change = {},
				onPassword2Change = {},
				onSignUpClick = {})
		}
	}
}