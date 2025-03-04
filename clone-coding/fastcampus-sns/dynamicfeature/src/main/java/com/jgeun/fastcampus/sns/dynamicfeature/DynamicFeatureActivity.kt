package com.jgeun.fastcampus.sns.dynamicfeature

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.jgeun.fastcampus.sns.app.FooEntryPoint
import com.jgeun.fastcampus.sns.data.UserDataStore
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

/**
 * @author   JGeun
 * @created  2025/03/01
 */
class DynamicFeatureActivity : ComponentActivity() {

	@Inject
	lateinit var userDataStore: UserDataStore

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val entryPoint = EntryPointAccessors.fromApplication(applicationContext, FooEntryPoint::class.java)
		val foo = entryPoint.foo()

		val component = DaggerDynamicFeatureComponent.builder()
			.fooEntryPoint(entryPoint)
			.build()

		component.inject(this)

		Log.e("DynamicFeature", "foo = $foo")
		Log.e("DynamicFeature", "userDataStore = ${this::userDataStore.isInitialized}")
	}
}