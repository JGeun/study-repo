package com.jgeun.kotlin.reflection.convert

fun main() {
	val testDTO = TestDTO(1, "2")

	val convertMapper1 = ConvertMapper(TestDTO::class, TestVO1::class)
	convertMapper1.printReflectionData()
	val testVO1 = convertMapper1.invoke(testDTO)
	println(testVO1)

	val convertMapper2 = ConvertMapper(TestDTO::class, TestVO2::class)
	val testVO2 = convertMapper2.invoke(testDTO)
	println(testVO2)
}