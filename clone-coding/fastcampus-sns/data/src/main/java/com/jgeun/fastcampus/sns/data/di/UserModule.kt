package com.jgeun.fastcampus.sns.data.di

import com.jgeun.fastcampus.sns.data.usecase.ClearTokenUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.GetTokenUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.LoginUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.SetTokenUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.SignUpUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.main.setting.GetMyUserUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.main.setting.SetMyUserUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.main.setting.SetProfileImageUseCaseImpl
import com.jgeun.fastcampus.sns.domain.usecase.login.ClearTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.login.GetTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.login.LoginUseCase
import com.jgeun.fastcampus.sns.domain.usecase.login.SetTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.login.SignUpUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.GetMyUserUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.SetMyUserUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.SetProfileImageUseCase
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

	@Binds
	abstract fun bindGetMyUserUseCase(uc: GetMyUserUseCaseImpl): GetMyUserUseCase

	@Binds
	abstract fun bindSetMyUserUseCase(uc: SetMyUserUseCaseImpl): SetMyUserUseCase

	@Binds
	abstract fun bindSetProfileImageUseCase(uc: SetProfileImageUseCaseImpl): SetProfileImageUseCase
}