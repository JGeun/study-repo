package com.jgeun.fastcampus.sns.domain.usecase.login

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
interface SignUpUseCase {

	suspend operator fun invoke(
		id:String,
		username: String,
		password: String
	): Result<Boolean>
}