package com.jgeun.fastcampus.sns.domain.usecase.file

import com.jgeun.fastcampus.sns.domain.model.Image

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface UploadImageUseCase {

	suspend operator fun invoke(image: Image): Result<String>
}