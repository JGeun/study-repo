package com.jgeun.fastcampus.sns.data.usecase

import com.jgeun.fastcampus.sns.data.UserDataStore
import com.jgeun.fastcampus.sns.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
class GetTokenUseCaseImpl @Inject constructor(
	private val userDataStore: UserDataStore
) : GetTokenUseCase {

	override suspend fun invoke(): String? {
		return userDataStore.getToken()
	}
}