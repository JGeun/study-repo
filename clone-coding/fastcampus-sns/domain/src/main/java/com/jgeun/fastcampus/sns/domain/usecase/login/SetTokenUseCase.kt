package com.jgeun.fastcampus.sns.domain.usecase.login

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
interface SetTokenUseCase {

	suspend operator fun invoke(token: String)
}