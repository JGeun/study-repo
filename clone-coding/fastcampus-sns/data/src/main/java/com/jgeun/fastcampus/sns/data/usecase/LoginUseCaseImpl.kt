package com.jgeun.fastcampus.sns.data.usecase

import com.jgeun.fastcampus.sns.data.model.LoginParam
import com.jgeun.fastcampus.sns.data.retrofit.UserService
import com.jgeun.fastcampus.sns.domain.usecase.LoginUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/17
 */
class LoginUseCaseImpl @Inject constructor(
	private val userService: UserService
) : LoginUseCase {

	override suspend fun invoke(id: String, password: String): Result<String> = runCatching {

		val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
		userService.login(requestBody = requestBody).data
	}
}