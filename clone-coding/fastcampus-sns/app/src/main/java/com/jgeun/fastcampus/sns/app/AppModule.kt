package com.jgeun.fastcampus.sns.app

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

	@Binds
	abstract fun bindContext(application: Application): Context
}