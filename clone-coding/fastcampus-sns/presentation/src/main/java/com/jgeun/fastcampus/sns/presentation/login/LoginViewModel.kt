package com.jgeun.fastcampus.sns.presentation.login

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.jgeun.fastcampus.sns.domain.usecase.login.LoginUseCase
import com.jgeun.fastcampus.sns.domain.usecase.login.SetTokenUseCase
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
 * @created  2025/02/16
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
	private val loginUseCase: LoginUseCase,
	private val setTokenUseCase: SetTokenUseCase,
) : ViewModel(), ContainerHost<LoginState, LoginSideEffect> {

	override val container: Container<LoginState, LoginSideEffect> = container(
		initialState = LoginState(),
		buildSettings = {
			this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
				intent {
					postSideEffect(LoginSideEffect.Toast(message = throwable.message.orEmpty()))
				}
			}
		}
	)

	fun onLoginClick() = intent {
		val id = state.id
		val password = state.password

		val token = loginUseCase(id, password).getOrThrow()
		setTokenUseCase(token)
//		postSideEffect(LoginSideEffect.Toast(message = "token = $token"))
		postSideEffect(LoginSideEffect.NavigateToMainActivity)
	}

	@OptIn(OrbitExperimental::class)
	fun onIdChange(id: String) = blockingIntent {
		reduce {
			state.copy(id = id)
		}
	}

	@OptIn(OrbitExperimental::class)
	fun onPasswordChange(password: String) = blockingIntent {
		reduce {
			state.copy(password = password)
		}
	}
}

@Immutable
data class LoginState(
	val id: String = "",
	val password: String = ""
)

sealed interface LoginSideEffect {
	data class Toast(val message: String): LoginSideEffect
	data object NavigateToMainActivity: LoginSideEffect
}