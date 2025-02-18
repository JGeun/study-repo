package com.jgeun.fastcampus.sns.domain.usecase

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
interface GetTokenUseCase {

	suspend operator fun invoke(): String?
}