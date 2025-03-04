package com.jgeun.fastcampus.sns.domain.usecase.main.writing

import com.jgeun.fastcampus.sns.domain.model.Image

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface GetImageListUseCase {

	suspend operator fun invoke(): List<Image>
}