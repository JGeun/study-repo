package com.jgeun.fastcampus.sns.domain.usecase.main.setting

import com.jgeun.fastcampus.sns.domain.model.User

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface GetMyUserUseCase {

	suspend operator fun invoke() : Result<User>
}