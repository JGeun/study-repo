package com.jgeun.fastcampus.sns.data.di

import com.jgeun.fastcampus.sns.data.usecase.main.board.DeleteBoardUseCaseImpl
import com.jgeun.fastcampus.sns.data.usecase.main.board.GetBoardsUseCaseImpl
import com.jgeun.fastcampus.sns.domain.usecase.main.board.DeleteBoardUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.board.GetBoardsUseCase
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
abstract class BoardModule {

	@Binds
	abstract fun bindGetBoardsUseCase(uc: GetBoardsUseCaseImpl): GetBoardsUseCase

	@Binds
	abstract fun bindDeleteBoardUseCase(uc: DeleteBoardUseCaseImpl): DeleteBoardUseCase
}