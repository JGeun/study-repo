package com.jgeun.fastcampus.sns.presentation.main.setting

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.jgeun.fastcampus.sns.domain.model.User
import com.jgeun.fastcampus.sns.domain.usecase.login.ClearTokenUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.GetMyUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
@HiltViewModel
class SettingViewModel @Inject constructor(
	private val clearTokenUseCase: ClearTokenUseCase,
	private val getMyUserUseCase: GetMyUserUseCase
) : ViewModel(), ContainerHost<SettingState, SettingSideEffect> {

	override val container: Container<SettingState, SettingSideEffect> = container(
		initialState = SettingState(),
		buildSettings = {
			this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
				intent { postSideEffect(SettingSideEffect.Toast(throwable.message.orEmpty())) }
			}
		}
	)

	init {
		load()
	}

	private fun load() = intent {
		val user: User = getMyUserUseCase().getOrThrow()
		reduce {
			state.copy(
				profileImageUrl = user.profileImageUrl,
				username = user.username
			)
		}
	}

	fun onLogoutClick()  = intent {
		clearTokenUseCase().getOrThrow()
		postSideEffect(SettingSideEffect.NavigateToLoginActivity)
	}
}

@Immutable
data class SettingState(
	val profileImageUrl: String? = null,
	val username: String = ""
)

sealed interface SettingSideEffect {
	data class Toast(val message: String) : SettingSideEffect

	data object NavigateToLoginActivity : SettingSideEffect
}