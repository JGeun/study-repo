package com.jgeun.fastcampus.sns.presentation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 *
 * @author   JGeun
 * @created  2025/02/16
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FCTextField(
	modifier: Modifier = Modifier,
	value: String,
	onValueChange: (String) -> Unit
) {
	TextField(
		modifier = modifier,
		value = value,
		onValueChange = onValueChange,
		colors = TextFieldDefaults.textFieldColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
		),
		shape = RoundedCornerShape(8.dp),
	)
}