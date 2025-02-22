package com.jgeun.fastcampus.sns.presentation.main.setting

import android.content.Intent
import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jgeun.fastcampus.sns.presentation.component.FCProfileImage
import com.jgeun.fastcampus.sns.presentation.login.LoginActivity
import com.jgeun.fastcampus.sns.presentation.theme.ConnectedTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@Composable
fun SettingScreen(
	viewModel: SettingViewModel = hiltViewModel()
) {
	val context = LocalContext.current
	val state = viewModel.collectAsState().value

	var usernameDialogVisible by remember { mutableStateOf(false) }
	viewModel.collectSideEffect { sideEffect ->
		when (sideEffect) {
			is SettingSideEffect.Toast -> {
				Toast.makeText(
					context,
					sideEffect.message,
					Toast.LENGTH_SHORT
				).show()
			}

			SettingSideEffect.NavigateToLoginActivity -> {
				context.startActivity(
					Intent(context, LoginActivity::class.java).apply {
						flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
					}
				)
			}
		}
	}

	val visualMediaPicker = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.PickVisualMedia(),
		onResult = viewModel::onImageChange
	)

	SettingScreen(
		username = state.username,
		profileImageUrl = state.profileImageUrl,
		onImageChangeClick = {
			visualMediaPicker.launch(
				PickVisualMediaRequest(
					ActivityResultContracts.PickVisualMedia.ImageOnly
				)
			)
		},
		onNameChangeClick = {
			usernameDialogVisible = true
		},
		onLogoutClick = viewModel::onLogoutClick
	)

	UsernameDialog(
		visible = usernameDialogVisible,
		initialUsername = state.username,
		onUsernameChange = viewModel::onUsernameChange,
		onDismissRequest = { usernameDialogVisible = false }
	)
}

@Composable
private fun SettingScreen(
	username: String = "",
	profileImageUrl: String?,
	onImageChangeClick: () -> Unit,
	onNameChangeClick: () -> Unit,
	onLogoutClick: () -> Unit
) {
	Column(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Box {
			FCProfileImage(
				modifier = Modifier.size(150.dp),
				profileImageUrl = profileImageUrl
			)

			IconButton(
				modifier = Modifier.align(Alignment.BottomEnd),
				onClick = onImageChangeClick
			) {
				Box(
					modifier = Modifier
						.size(30.dp)
						.border(width = 1.dp, color = Color.Gray, shape = CircleShape)
						.background(color = Color.White, shape = CircleShape)
				) {
					Icon(
						modifier = Modifier
							.align(Alignment.Center)
							.size(20.dp),
						imageVector = Icons.Outlined.Settings,
						contentDescription = null,
						tint = MaterialTheme.colorScheme.primary
					)
				}
			}
		}

		Text(
			modifier = Modifier
				.padding(top = 3.dp)
				.clickable { onNameChangeClick() },
			text = username,
			style = MaterialTheme.typography.headlineMedium
		)
		Button(
			modifier = Modifier.padding(top = 16.dp),
			onClick = onLogoutClick
		) {
			Text("로그아웃")
		}
	}
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SettingScreenPreview() {
	ConnectedTheme {
		Surface {
			SettingScreen(
				username = "JGeun",
				profileImageUrl = null,
				onImageChangeClick = {},
				onNameChangeClick = {},
				onLogoutClick = {}
			)
		}
	}
}