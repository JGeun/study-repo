package com.jgeun.fastcampus.sns.data.di

import com.jgeun.fastcampus.sns.data.usecase.ClearTokenUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.GetTokenUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.LoginUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.SetTokenUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.SignUpUseCaseImpl
import com.jgeun.fastcampus.sns.domain.usecase.ClearTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.GetTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.LoginUseCase
import com.jgeun.fastcampus.sns.domain.usecase.SetTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.SignUpUseCase
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

	@Binds
	abstract fun bindSignUpUseCase(uc: SignUpUseCaseImpl): SignUpUseCase

	@Binds
	abstract fun bindGetTokenUseCase(uc: GetTokenUseCaseImpl): GetTokenUseCase

	@Binds
	abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl): SetTokenUseCase
	@Binds
	abstract fun bindClearTokenUseCase(uc: ClearTokenUseCaseImpl): ClearTokenUseCase
}