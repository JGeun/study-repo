package com.jgeun.kotlin.reflection.basic

/**
 *
 * @author   JGeun
 * @created  2025/02/01
 */
fun main() {
	val myClass = ReflectionTestData::class
	val basicReflection = BasicReflection(myClass)
	basicReflection.printReflectionData()
}