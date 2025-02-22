package com.jgeun.fastcampus.sns.domain.usecase.main.setting

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface SetProfileImageUseCase {

	suspend operator fun invoke(contentUri: String): Result<Unit>
}