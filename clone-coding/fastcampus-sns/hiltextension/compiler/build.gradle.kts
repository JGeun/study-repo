plugins {
	id("java-library")
	alias(libs.plugins.jetbrains.kotlin.jvm)
	id("kotlin-kapt")
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
	implementation(project(":clone-coding:fastcampus-sns:hiltextension:annotations"))

	implementation("com.squareup:javapoet:1.13.0")
	compileOnly("com.google.auto.service:auto-service-annotations:1.0-rc7")
	kapt("com.google.auto.service:auto-service:1.0-rc7")
}