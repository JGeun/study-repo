package com.jgeun.fastcampus.sns.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeun.fastcampus.sns.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
	private val loginUseCase: LoginUseCase,
) : ViewModel() {

	fun onLoginClick() {
		val id = ""
		val password = ""

		viewModelScope.launch {
			loginUseCase(id, password)
		}
	}
}