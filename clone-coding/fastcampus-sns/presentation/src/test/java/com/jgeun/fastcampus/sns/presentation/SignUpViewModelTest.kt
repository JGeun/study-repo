package com.jgeun.fastcampus.sns.presentation

import com.jgeun.fastcampus.sns.domain.usecase.login.SignUpUseCase
import com.jgeun.fastcampus.sns.presentation.login.SignUpSideEffect
import com.jgeun.fastcampus.sns.presentation.login.SignUpViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *
 * @author   JGeun
 * @created  2025/02/24
 */
private const val TEST_Id = "JGeun"
private const val TEST_PASSWORD = "1234"
private const val TEST_USERNAME = "JGeun"

class SignUpViewModelTest {

    // given - 객체 생성
    lateinit var signUpUseCase: SignUpUseCase
    lateinit var viewModel: SignUpViewModel

    @Before
    fun setup() {
        signUpUseCase = FakeSignUpUseCase()
        viewModel = SignUpViewModel(signUpUseCase)
    }

    @Test
    fun 입력된_아이디_상태_테스트() {
        Assert.assertEquals(viewModel.container.stateFlow.value.id, "")

        // when - 액션, 텍스트 입력
        viewModel.onIdChange(TEST_Id)

        // then - 검증
        Assert.assertEquals(viewModel.container.stateFlow.value.id, TEST_Id)
    }

    @Test
    fun 입력된_패스워드_상태_테스트() {
        Assert.assertEquals(viewModel.container.stateFlow.value.id, "")

        // when - 액션, 텍스트 입력
        viewModel.onPasswordChange(TEST_PASSWORD)

        // then - 검증
        Assert.assertEquals(viewModel.container.stateFlow.value.password, TEST_PASSWORD)
    }

    @Test
    fun 회원가입_버튼_클릭_실패_테스트() = runTest {
        val vm = SignUpViewModel(signUpUseCase)
        vm.onIdChange(TEST_Id)
        vm.onPasswordChange(TEST_PASSWORD)
//        vm.onRepeatPasswordChange(TEST_PASSWORD)
        vm.onSignUpClick()
        val sideEffect = vm.container.sideEffectFlow.first()
        Assert.assertEquals((sideEffect as? SignUpSideEffect.Toast)?.message, "패스워드가 일치하지 않습니다.")
    }

    @Test
    fun 회원가입_버튼_클릭_성공_테스트() = runTest {
        val vm = SignUpViewModel(signUpUseCase)
        vm.onIdChange(TEST_Id)
        vm.onUsernameChange(TEST_USERNAME)
        vm.onPasswordChange(TEST_PASSWORD)
        vm.onRepeatPasswordChange(TEST_PASSWORD)
        vm.onSignUpClick()
        val sideEffect = vm.container.sideEffectFlow.first()
        Assert.assertTrue(sideEffect is SignUpSideEffect.NavigateToLoginScreen)
    }

    class FakeSignUpUseCase : SignUpUseCase {

        override suspend fun invoke(
            id: String,
            username: String,
            password: String
        ): Result<Boolean> = runCatching {
            id == TEST_Id && username == "JGeun" && password == TEST_PASSWORD
        }
    }
}