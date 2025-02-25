package com.jgeun.assistedinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideUserService(): UserService {
        return UserServiceImpl()
    }
}