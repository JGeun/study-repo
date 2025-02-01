package com.jgeun.kotlin.reflection.convert

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

private typealias Mapper<I, O> = (I) -> O

class ConvertMapper<I : Any, O : Any>(
	private val inType: KClass<I>,
	private val outType: KClass<O>
) : Mapper<I, O> {

	private val outConstructor: KFunction<O> = outType.primaryConstructor!!
	private val inPropertiesByName: Map<String, KProperty1<I, *>> by lazy { inType.memberProperties.associateBy { it.name } }

	private fun argFor(parameter: KParameter, data: I): Any? {
		return inPropertiesByName[parameter.name]?.get(data)
	}

	override fun invoke(data: I): O = with(outConstructor) {
		callBy(parameters.associateWith { argFor(it, data) })
	}

	fun printReflectionData() {
		println("inPropertiesByName:$inPropertiesByName")
	}

	companion object {
		inline operator fun <reified I : Any, reified O : Any> invoke() =
			ConvertMapper(I::class, O::class)
	}
}