package com.jgeun.fastcampus.sns.domain.usecase

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
interface SignUpUseCase {

	suspend operator fun invoke(
		id:String,
		userName: String,
		password: String
	): Result<Unit>
}