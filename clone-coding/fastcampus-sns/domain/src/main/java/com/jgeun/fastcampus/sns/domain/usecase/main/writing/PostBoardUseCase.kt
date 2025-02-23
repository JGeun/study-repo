package com.jgeun.fastcampus.sns.domain.usecase.main.writing

import com.jgeun.fastcampus.sns.domain.model.Image

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface PostBoardUseCase {

	suspend operator fun invoke(
		title: String,
		content: String,
		images: List<Image>
	)
}