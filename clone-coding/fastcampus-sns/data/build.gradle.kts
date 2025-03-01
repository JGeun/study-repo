plugins {
	alias(libs.plugins.com.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.hilt)
	id("kotlin-kapt")
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.kotlin.parcelize)
	id("com.google.devtools.ksp")
}

android {
	namespace = "com.jgeun.fastcampus.sns.data"
	compileSdk = 34

	defaultConfig {
		minSdk = 26

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	kapt {
		correctErrorTypes = true
	}
}

dependencies {
	implementation(project(":clone-coding:fastcampus-sns:domain"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	implementation(libs.datastore)

	implementation(libs.retrofit)
	implementation(libs.retrofit.converter.serialization)

	implementation(libs.kotlinx.serialization.json)
	implementation(libs.okhttp)
	implementation(libs.okhttp.interceptor)

	implementation(libs.hilt)
	kapt(libs.hilt.compiler)

	implementation(libs.androidx.lifecycle.service)

	implementation(libs.paging.common)
	implementation(libs.paging.runtime)
	implementation(libs.paging.compose)

	implementation(libs.room.runtime)
	implementation(libs.room.paging)
	ksp(libs.room.compiler)

	androidTestImplementation(libs.kotlinx.coroutines.test)

	// hilt+ work
	implementation(libs.androidx.work.runtime)
	implementation(libs.androidx.hilt.work)
	kapt(libs.androidx.hilt.compiler)
}