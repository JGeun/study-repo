package com.jgeun.fastcampus.sns.data.usecase.main.setting

import com.jgeun.fastcampus.sns.data.model.UpdateMyInfoParam
import com.jgeun.fastcampus.sns.data.retrofit.UserService
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.GetMyUserUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
class SetMyUserUseCaseImpl @Inject constructor(
	private val userService: UserService,
	private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {

	override suspend fun invoke(
		username: String?,
		profileImageUrl: String?
	): Result<Unit> = runCatching {
		val user = getMyUserUseCase().getOrThrow()
		val requestBody = UpdateMyInfoParam(
			userName = username ?: user.username,
			profileFilePath = profileImageUrl ?: user.profileImageUrl.orEmpty(),
			extraUserInfo = ""
		).toRequestBody()
		userService.patchMyPage(requestBody)
	}
}