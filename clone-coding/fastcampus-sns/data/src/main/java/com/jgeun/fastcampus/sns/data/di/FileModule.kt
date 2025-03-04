package com.jgeun.fastcampus.sns.data.di

import com.jgeun.fastcampus.sns.data.usecase.file.GetImageUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.file.GetInputStreamUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.file.UploadImageUseCaseImpl
import com.jgeun.fastcampus.sns.domain.usecase.file.GetImageUseCase
import com.jgeun.fastcampus.sns.domain.usecase.file.GetInputStreamUseCase
import com.jgeun.fastcampus.sns.domain.usecase.file.UploadImageUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {

	@Binds
	abstract fun bindGetInputStreamUseCase(uc: GetInputStreamUseCaseImpl): GetInputStreamUseCase

	@Binds
	abstract fun bindGetImageUseCase(uc: GetImageUseCaseImpl): GetImageUseCase

	@Binds
	abstract fun bindUploadImageUseCase(uc: UploadImageUseCaseImpl): UploadImageUseCase
}