package com.jgeun.assistedinjection

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
@AndroidEntryPoint
class UserActivity : ComponentActivity() {

    @Inject
    lateinit var getUserInfoUseCaseFactory: GetUserInfoUseCaseFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userNo = intent.getLongExtra("userNo", -1L)

        val getUserInfoUseCase = getUserInfoUseCaseFactory.create(userNo)
        val user = getUserInfoUseCase.getUser()
        Log.e("UserActivity", "user: $user")
    }
}