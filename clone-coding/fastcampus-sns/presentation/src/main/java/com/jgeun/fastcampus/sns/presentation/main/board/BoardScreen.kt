package com.jgeun.fastcampus.sns.presentation.main.board

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.jgeun.fastcampus.sns.presentation.model.main.board.BoardCardModel
import com.jgeun.fastcampus.sns.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Composable
fun BoardScreen(
	viewModel: BoardViewModel
) {
	val state = viewModel.collectAsState().value
	var modelForDialog: BoardCardModel? by remember { mutableStateOf(null) }
	val context = LocalContext.current

	viewModel.collectSideEffect { sideEffect ->
		when (sideEffect) {
			is BoardSideEffect.Toast -> Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
		}
	}

	BoardScreen(
		boardCardModels = state.boardCardModelFlow.collectAsLazyPagingItems(),
		deletedBoardIds = state.deletedBoardIds,
		onOptionClick = { modelForDialog = it },
		onReplyClick = {}
	)
	BoardOptionDialog(
		model = modelForDialog,
		onDismissRequest = { modelForDialog = null },
		onBoardDelete = viewModel::onBoardDelete

	)
}

@Composable
private fun BoardScreen(
	boardCardModels: LazyPagingItems<BoardCardModel>,
	deletedBoardIds: Set<Long> = emptySet(),
	onOptionClick: (BoardCardModel) -> Unit,
	onReplyClick: (BoardCardModel) -> Unit,
) {
	Surface {
		LazyColumn(
			modifier = Modifier.fillMaxSize(),
		) {
			items(
				count = boardCardModels.itemCount,
				key = { index -> boardCardModels[index]?.boardId ?: index },
			) { index ->
				boardCardModels[index]?.run {
					if (!deletedBoardIds.contains(this.boardId)) {
						BoardCard(
							username = this.username,
							images = this.images,
							text = this.text,
							onOptionClick = { onOptionClick(this) },
							onReplyClick = { onReplyClick(this) }
						)
					}
				}
			}
		}
	}
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardScreenPreview() {
	ConnectedTheme {
//        BoardScreen(
//            boardCardModels = ,
//            onOptionClick = {},
//            onReplyClick = {}
//        )
	}
}