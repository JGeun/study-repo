package com.jgeun.fastcampus.sns.domain.usecase.login

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
interface ClearTokenUseCase {

	suspend operator fun invoke(): Result<Unit>
}