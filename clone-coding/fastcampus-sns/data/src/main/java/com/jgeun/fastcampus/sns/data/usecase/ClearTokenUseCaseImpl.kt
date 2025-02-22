package com.jgeun.fastcampus.sns.data.usecase

import com.jgeun.fastcampus.sns.data.UserDataStore
import com.jgeun.fastcampus.sns.domain.usecase.login.ClearTokenUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
class ClearTokenUseCaseImpl @Inject constructor(
	private val userDataStore: UserDataStore
) : ClearTokenUseCase {

	override suspend fun invoke() = kotlin.runCatching {
		userDataStore.clear()
	}
}