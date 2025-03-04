package com.jgeun.fastcampus.sns.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.jgeun.fastcampus.sns.domain.usecase.login.GetTokenUseCase
import com.jgeun.fastcampus.sns.presentation.login.LoginActivity
import com.jgeun.fastcampus.sns.presentation.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

	@Inject
	lateinit var getTokenUseCase: GetTokenUseCase

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		lifecycleScope.launch {
			val isLoggedIn = !getTokenUseCase().isNullOrEmpty()

			if (isLoggedIn) {
				// 로그인 되었을 때
				startActivity(
					Intent(
						this@SplashActivity, MainActivity::class.java
					).apply {
						flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
					}
				)
			} else {
				startActivity(
					Intent(
						this@SplashActivity, LoginActivity::class.java
					).apply {
						flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
					}
				)
			}
		}
	}
}