package com.jgeun.fastcampus.sns.data.di

import com.jgeun.fastcampus.sns.domain.qualifier.Default
import com.jgeun.fastcampus.sns.domain.qualifier.Hilt
import com.jgeun.fastcampus.sns.data.usecase.main.writing.GetImageListUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.main.writing.HiltWorkerPostBoardUseCase
import com.jgeun.fastcampus.sns.data.usecase.main.writing.PostBoardUseCaseImpl
import com.jgeun.fastcampus.sns.domain.usecase.main.writing.GetImageListUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.writing.PostBoardUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WritingModule {

	@Binds
	abstract fun bindGetImageListUseCase(uc: GetImageListUseCaseImpl): GetImageListUseCase

	@Binds
	@Default
	abstract fun bindDefaultPostBoardUseCase(uc: PostBoardUseCaseImpl): PostBoardUseCase

	@Binds
	@Hilt
	abstract fun bindHiltPostBoardUseCase(uc: HiltWorkerPostBoardUseCase): PostBoardUseCase
}