package com.jgeun.fastcampus.sns.app

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
@HiltAndroidApp
class FastCampusSnsApp : Application(), Configuration.Provider {

	@Inject
	lateinit var hiltWorkerFactory: HiltWorkerFactory

	override val workManagerConfiguration: Configuration
		get() = Configuration.Builder()
			.setWorkerFactory(hiltWorkerFactory)
			.build()
}
