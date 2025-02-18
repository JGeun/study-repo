package com.jgeun.fastcampus.sns.presentation.login

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.jgeun.fastcampus.sns.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/18
 */
@HiltViewModel
class SignUpViewModel @Inject constructor(
	private val signUpUseCase: SignUpUseCase
): ViewModel(), ContainerHost<SignUpState, SignUpSideEffect> {

	override val container: Container<SignUpState, SignUpSideEffect> = container(
		initialState = SignUpState(),
		buildSettings = {
			this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
				// Handle exceptions
				intent { postSideEffect(SignUpSideEffect.Toast(message = throwable.message.orEmpty())) }
			}
		}
	)

	@OptIn(OrbitExperimental::class)
	fun onIdChange(id: String) = blockingIntent {
		reduce { state.copy(id = id) }
	}

	@OptIn(OrbitExperimental::class)
	fun onUsernameChange(username: String) = blockingIntent {
		reduce { state.copy(username = username) }
	}

	@OptIn(OrbitExperimental::class)
	fun onPasswordChange(password: String) = blockingIntent {
		reduce { state.copy(password = password) }
	}

	@OptIn(OrbitExperimental::class)
	fun onRepeatPasswordChange(repeatPassword: String) = blockingIntent {
		reduce { state.copy(repeatPassword = repeatPassword) }
	}

	fun onSignUpClick() = intent {
		if(state.password != state.repeatPassword) {
			postSideEffect(SignUpSideEffect.Toast(message = "패스워드가 일치하지 않습니다."))
			return@intent
		}

		val isSuccessful = signUpUseCase(
			id = state.id,
			username = state.username,
			password = state.password
		).getOrThrow()

		if (isSuccessful) {
			postSideEffect(SignUpSideEffect.NavigateToLoginScreen)
			postSideEffect(SignUpSideEffect.Toast(message = "회원가입에 성공했습니다."))
		}
	}
}

@Immutable
data class SignUpState(
	val id: String = "",
	val username: String = "",
	val password: String = "",
	val repeatPassword: String = ""
)

sealed interface SignUpSideEffect {
	data class Toast(val message: String) : SignUpSideEffect

	data object NavigateToLoginScreen : SignUpSideEffect
}