package com.jgeun.fastcampus.sns.domain.usecase.main.setting

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface SetMyUserUseCase {

	suspend operator fun invoke(
		username: String? = null,
		profileImageUrl: String? = null
	): Result<Unit>
}