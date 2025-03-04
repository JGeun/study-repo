package com.jgeun.fastcampus.sns.domain.usecase.file

import java.io.InputStream

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
interface GetInputStreamUseCase {
	operator fun invoke(contentUri: String): Result<InputStream>
}