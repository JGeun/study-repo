package com.jgeun.fastcampus.sns.data.usecase.main.setting

import com.jgeun.fastcampus.sns.data.model.toDomainModel
import com.jgeun.fastcampus.sns.data.retrofit.UserService
import com.jgeun.fastcampus.sns.domain.model.User
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
class GetMyUserUseCaseImpl @Inject constructor(
	private val userService: UserService
): GetMyUserUseCase {

	override suspend fun invoke(): Result<User> = runCatching {
		userService.getMyPage().data.toDomainModel()
	}
}