package com.jgeun.fastcampus.sns.data.usecase.main.setting

import android.util.Log
import com.jgeun.fastcampus.sns.data.constant.FC_HOST
import com.jgeun.fastcampus.sns.domain.model.Image
import com.jgeun.fastcampus.sns.domain.usecase.file.GetImageUseCase
import com.jgeun.fastcampus.sns.domain.usecase.file.UploadImageUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.GetMyUserUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.SetMyUserUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.setting.SetProfileImageUseCase
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
class SetProfileImageUseCaseImpl @Inject constructor(
	private val uploadImageUseCase: UploadImageUseCase,
	private val getImageUseCase: GetImageUseCase,
	private val setMyUserUseCase: SetMyUserUseCase,
	private val getMyUserUseCase: GetMyUserUseCase
) : SetProfileImageUseCase {

	override suspend fun invoke(contentUri: String): Result<Unit> = runCatching {
		// 0. 내 정보 가져오기
		val user = getMyUserUseCase().getOrThrow()

		// 1. 이미지 정보 가져오기
		val image: Image = getImageUseCase(contentUri = contentUri) ?: throw NullPointerException("이미지를 찾을 수 없습니다.")

		// 2. 이미지 업로드 하기
		val imagePath = uploadImageUseCase(image).getOrThrow().also {
			Log.d("SetProfileImageUseCase", "imagePath: $it")
		}

		Log.d("SetProfileImageUseCase", "profileImageUrl:${FC_HOST + imagePath}")

		// 3. 내 정보 업데이트 하기
		setMyUserUseCase(
			profileImageUrl = imagePath
		).getOrThrow()
			.also {
				Log.d("setMyUserUseCase", "result: $it")
			}
	}
}