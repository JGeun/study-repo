plugins {
	alias(libs.plugins.com.android.dynamic.feature)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.hilt)
	id("kotlin-kapt")
}

android {
	namespace = "com.jgeun.fastcampus.sns.dynamicfeature"
	compileSdk = 34

	defaultConfig {
		minSdk = 26
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
	implementation(project(":clone-coding:fastcampus-sns:app"))
	implementation(project(":clone-coding:fastcampus-sns:data"))

	implementation(libs.androidx.core.ktx)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	implementation(libs.hilt)
	kapt(libs.hilt.compiler)
}