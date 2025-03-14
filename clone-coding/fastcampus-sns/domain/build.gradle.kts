plugins {
	id("java-library")
	alias(libs.plugins.jetbrains.kotlin.jvm)
	alias(libs.plugins.kotlin.serialization)
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
	implementation(libs.kotlinx.serialization.json)

	implementation(libs.paging.common)
	implementation("javax.inject:javax.inject:1")
}