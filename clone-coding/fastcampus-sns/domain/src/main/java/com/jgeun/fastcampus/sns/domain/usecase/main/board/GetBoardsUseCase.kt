package com.jgeun.fastcampus.sns.domain.usecase.main.board

import androidx.paging.PagingData
import com.jgeun.fastcampus.sns.domain.model.Board
import kotlinx.coroutines.flow.Flow

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
interface GetBoardsUseCase {

	suspend operator fun invoke(): Result<Flow<PagingData<Board>>>
}