package com.jgeun.fastcampus.sns.data.usecase

import com.jgeun.fastcampus.sns.data.model.SignUpParam
import com.jgeun.fastcampus.sns.data.retrofit.UserService
import com.jgeun.fastcampus.sns.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
class SignUpUseCaseImpl @Inject constructor(
	private val userService: UserService
) : SignUpUseCase {

	override suspend fun invoke(id: String, username: String, password: String): Result<Boolean> = runCatching {
		val requestBody = SignUpParam(
			loginId = id,
			name = username,
			password = password,
			extraUserInfo = "",
			profileFilePath = ""
		).toRequestBody()

		userService.signUp(requestBody = requestBody).result == "SUCCESS"
	}
}