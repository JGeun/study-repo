package com.jgeun.fastcampus.sns.domain.usecase.login

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
interface LoginUseCase {

	suspend operator fun invoke(id: String, password: String): Result<String>
}