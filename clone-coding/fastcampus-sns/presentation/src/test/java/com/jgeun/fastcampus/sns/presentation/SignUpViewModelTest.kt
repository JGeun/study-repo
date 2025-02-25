package com.jgeun.fastcampus.sns.presentation

import com.jgeun.fastcampus.sns.domain.usecase.login.SignUpUseCase
import com.jgeun.fastcampus.sns.presentation.login.SignUpViewModel
import org.junit.Assert
import org.junit.Test

/**
 *
 * @author   JGeun
 * @created  2025/02/24
 */
private const val TEST_Id = "JGeun"
private const val TEST_PASSWORD = "1234"

class SignUpViewModelTest {

    @Test
    fun 입력된_아이디_상태_테스트() {
        // given - 객체 생성
        val signUpUseCase = FakeSignUpUseCase()
        val viewModel = SignUpViewModel(signUpUseCase)
        Assert.assertEquals(viewModel.container.stateFlow.value.id, "")

        // when - 액션, 텍스트 입력
        viewModel.onIdChange(TEST_Id)

        // then - 검증
        Assert.assertEquals(viewModel.container.stateFlow.value.id, TEST_Id)
    }

    @Test
    fun 입력된_패스워드_상태_테스트() {
        // given - 객체 생성
        val signUpUseCase = FakeSignUpUseCase()
        val viewModel = SignUpViewModel(signUpUseCase)
        Assert.assertEquals(viewModel.container.stateFlow.value.id, "")

        // when - 액션, 텍스트 입력
        viewModel.onPasswordChange(TEST_PASSWORD)

        // then - 검증
        Assert.assertEquals(viewModel.container.stateFlow.value.password, TEST_PASSWORD)
    }

    class FakeSignUpUseCase : SignUpUseCase {

        override suspend fun invoke(
            id: String,
            username: String,
            password: String
        ): Result<Boolean> = runCatching {
            true
        }
    }
}