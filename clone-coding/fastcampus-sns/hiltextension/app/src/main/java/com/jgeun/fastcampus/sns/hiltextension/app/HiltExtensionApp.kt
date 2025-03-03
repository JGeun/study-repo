package com.jgeun.fastcampus.sns.hiltextension.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @author   JGeun
 * @created  2025/03/01
 */
@HiltAndroidApp
class HiltExtensionApp : Application() {

    @Inject
    lateinit var authenticator: Authenticator

    override fun onCreate() {
        super.onCreate()

        Log.e("HiltExtensionApp", "authenticator: ${this::authenticator.isInitialized}")
    }
}