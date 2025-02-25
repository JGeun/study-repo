package com.jgeun.fastcampus.sns.app

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
class CustomRunner : AndroidJUnitRunner( ){

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, MyCustom_Application::class.java.name, context)
    }
}