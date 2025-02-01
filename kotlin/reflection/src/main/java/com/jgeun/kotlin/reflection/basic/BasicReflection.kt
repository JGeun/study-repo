package com.jgeun.kotlin.reflection.basic

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 *
 * @author   JGeun
 * @created  2025/02/01
 */
class BasicReflection<T: Any>(
	private val type: KClass<T>
) {
	fun printReflectionData() {
		println("primaryConstructor: ${type.primaryConstructor}")
		println("memberProperties: ${type.memberProperties}")
	}
}