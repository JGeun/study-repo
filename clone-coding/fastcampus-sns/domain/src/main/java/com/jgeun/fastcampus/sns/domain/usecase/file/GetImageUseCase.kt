package com.jgeun.fastcampus.sns.domain.usecase.file

import com.jgeun.fastcampus.sns.domain.model.Image

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface GetImageUseCase {

	operator fun invoke(contentUri: String): Image?
}