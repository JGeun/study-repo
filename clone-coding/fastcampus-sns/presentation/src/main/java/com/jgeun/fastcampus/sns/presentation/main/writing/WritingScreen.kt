package com.jgeun.fastcampus.sns.presentation.main.writing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import com.jgeun.fastcampus.sns.presentation.component.FCImagePager
import com.jgeun.fastcampus.sns.presentation.component.FCTextField
import com.jgeun.fastcampus.sns.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@Composable
fun WritingScreen(
	viewModel: WritingViewModel,
	onBackClick: () -> Unit,
) {
	val state = viewModel.collectAsState().value
	WritingScreen(
		images = state.selectedImages.map { it.uri },
		text = state.text,
		onTextChange = viewModel::onTextChange,
		onBackClick = onBackClick,
		onPostClick = viewModel::onPostClick
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WritingScreen(
	images: List<String>,
	text: String,
	onTextChange: (String) -> Unit,
	onBackClick: () -> Unit,
	onPostClick: () -> Unit
) {
	Surface {
		Scaffold(
			topBar = {
				CenterAlignedTopAppBar(
					title = {
						Text(
							text = "새 게시물",
							style = MaterialTheme.typography.headlineSmall
						)
					},
					navigationIcon = {
						IconButton(onClick = onBackClick) {
							Icon(
								imageVector = Icons.Filled.ArrowBack,
								contentDescription = "뒤로가기"
							)
						}
					},
					actions = {
						TextButton(onClick = onPostClick) {
							Text(text = "게시")
						}
					}
				)
			},
			content = { paddingValues ->
				Column(modifier = Modifier.padding(paddingValues)) {
					FCImagePager(
						modifier = Modifier
							.fillMaxWidth()
							.weight(2f),
						images = images
					)
					Divider()
					FCTextField(
						modifier = Modifier
							.fillMaxWidth()
							.weight(3f),
						value = text,
						onValueChange = onTextChange
					)
				}
			}
		)

	}
}

@Preview
@Composable
private fun WritingScreenPreview() {
	ConnectedTheme {
		WritingScreen(
			text = "",
			onTextChange = {},
			images = emptyList(),
			onBackClick = {},
			onPostClick = {}
		)
	}
}