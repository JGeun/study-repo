plugins {
	alias(libs.plugins.com.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
//	alias(libs.plugins.hilt)
	id("kotlin-kapt")
	alias(libs.plugins.kotlin.serialization)
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

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	implementation(libs.datastore)

	implementation(libs.retrofit)
	implementation(libs.retrofit.converter.serialization)

//	implementation(libs.kotlinx.serialization.json)
//	implementation(libs.okhttp)

//	implementation(libs.hilt)
//	kapt(libs.hilt.compiler)
}