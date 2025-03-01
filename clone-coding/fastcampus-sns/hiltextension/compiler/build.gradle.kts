plugins {
	id("java-library")
	alias(libs.plugins.jetbrains.kotlin.jvm)
	id("kotlin-kapt")
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
	compilerOptions {
		jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
	}
}

dependencies {
	implementation(libs.javapoet)
	compileOnly("com.google.auto.service:auto-service-annotations:1.0.1")
	kapt("com.google.auto.service:auto-service:1.0.1")
}