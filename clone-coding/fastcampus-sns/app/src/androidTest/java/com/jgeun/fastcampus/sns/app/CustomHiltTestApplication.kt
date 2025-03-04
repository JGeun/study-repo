package com.jgeun.fastcampus.sns.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.testing.CustomTestApplication

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
open class CustomHiltTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("Hilt", "애플리케이션 생성 후, 비즈니스 로직 수행")
    }
}

@CustomTestApplication(CustomHiltTestApplication::class)
interface MyCustom {

}