package com.jgeun.fastcampus.sns.presentation.login

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
sealed class LoginRoute(
	val name: String
) {
	data object WelcomeScreen : LoginRoute("WelcomeScreen")

	data object LoginScreen : LoginRoute("LoginScreen")

	data object SignUpScreen : LoginRoute("SignUpScreen")
}