package com.jgeun.assistedinjection

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.migration.CustomInject
import dagger.hilt.android.migration.CustomInjection
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
class Foo @Inject constructor()

@HiltAndroidApp
@CustomInject
class MyApp  : Application() {

	@Inject
	lateinit var foo: Foo

	override fun onCreate() {
		Log.e("MyApp",  "foo1  = ${this::foo.isInitialized}")
		super.onCreate()
		Log.e("MyApp",  "foo1  = ${this::foo.isInitialized}")
		CustomInjection.inject(this)
		Log.e("MyApp",  "foo1  = ${this::foo.isInitialized}")
	}
}