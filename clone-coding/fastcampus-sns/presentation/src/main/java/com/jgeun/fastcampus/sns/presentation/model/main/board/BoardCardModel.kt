package com.jgeun.fastcampus.sns.presentation.model.main.board

import androidx.compose.runtime.Immutable
import com.jgeun.fastcampus.sns.domain.model.Board

@Immutable
data class BoardCardModel(
	val boardId: Long,
	val username: String,
	val images: List<String>,
	val text: String,
)

fun Board.toUiModel(): BoardCardModel {
	return BoardCardModel(
		boardId = this.id,
		username = this.username,
		images = this.images,
		text = this.content
	)
}