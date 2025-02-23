package com.jgeun.fastcampus.sns.presentation.model.main.board

import androidx.compose.runtime.Immutable
import com.jgeun.fastcampus.sns.domain.model.Board
import com.jgeun.fastcampus.sns.domain.model.Comment

/**
 * @author   JGeun
 * @created  2025/02/23
 */
@Immutable
data class BoardCardModel(
	val userId:Long,
	val boardId: Long,
	val username: String,
	val images: List<String>,
	val text: String,
	val comments:List<Comment>
)

fun Board.toUiModel(): BoardCardModel {
	return BoardCardModel(
		userId = this.userId,
		boardId = this.id,
		username = this.username,
		images = this.images,
		text = this.content,
		comments = this.comments
	)
}