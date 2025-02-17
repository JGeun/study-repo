package com.jgeun.fastcampus.sns.data.di

import com.jgeun.fastcampus.sns.data.usecase.LoginUseCaseImpl
import com.jgeun.fastcampus.sns.domain.usecase.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * @author   JGeun
 * @created  2025/02/17
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

	@Binds
	abstract fun bindLoginUseCase(uc: LoginUseCaseImpl): LoginUseCase
}