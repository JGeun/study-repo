package com.jgeun.fastcampus.sns.data.usecase

import com.jgeun.fastcampus.sns.data.UserDataStore
import com.jgeun.fastcampus.sns.domain.usecase.GetTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.SetTokenUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
class SetTokenUseCaseImpl @Inject constructor(
	private val userDataStore: UserDataStore
) : SetTokenUseCase {

	override suspend fun invoke(token: String) {
		return userDataStore.setToken(token)
	}
}