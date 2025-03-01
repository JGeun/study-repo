package com.jgeun.fastcampus.sns.presentation.main.writing

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.jgeun.fastcampus.sns.domain.qualifier.Hilt
import com.jgeun.fastcampus.sns.domain.model.Image
import com.jgeun.fastcampus.sns.domain.usecase.main.writing.GetImageListUseCase
import com.jgeun.fastcampus.sns.domain.usecase.main.writing.PostBoardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/23
 */
@HiltViewModel
class WritingViewModel @Inject constructor(
	private val getImageListUseCase: GetImageListUseCase,
	@Hilt private val postBoardUseCase: PostBoardUseCase
) : ViewModel(),
	ContainerHost<WritingState, WritingSideEffect> {
	override val container: Container<WritingState, WritingSideEffect> = container(
		initialState = WritingState(),
		buildSettings = {
			this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
				intent { postSideEffect(WritingSideEffect.Toast(throwable.message.orEmpty())) }
			}
		}
	)

	init {
		load()
	}

	private fun load() = intent {
		val images = getImageListUseCase()
		reduce {
			state.copy(
				selectedImages = images.firstOrNull()?.let { listOf(it) } ?: emptyList(),
				images = images
			)
		}
	}

	fun onItemClick(image: Image) = intent {
		reduce {
			if (state.selectedImages.contains(image)) {
				state.copy(
					selectedImages = state.selectedImages - image
				)
			} else {
				state.copy(
					selectedImages = state.selectedImages + image
				)
			}
		}
	}

	fun onTextChange(text: String) = blockingIntent {
		reduce {
			state.copy(text = text)
		}
	}

	fun onPostClick() = intent {
		postBoardUseCase(
			title = "제목없음",
			content = state.text,
			images = state.selectedImages
		)
		postSideEffect(WritingSideEffect.Finish)
	}
}

@Immutable
data class WritingState(
	val selectedImages: List<Image> = emptyList(),
	val images: List<Image> = emptyList(),
	val text: String = "",
)

sealed interface WritingSideEffect {
	data class Toast(val message: String) : WritingSideEffect
	data object Finish : WritingSideEffect
}