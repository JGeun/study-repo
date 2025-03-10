plugins {
	alias(libs.plugins.com.android.library)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.hilt)
	id("kotlin-kapt")
}

android {
	namespace = "com.jgeun.fastcampus.sns.presentation"
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
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.3"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	implementation(project(":clone-coding:fastcampus-sns:domain"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)

	// hilt
	implementation(libs.hilt)
	kapt(libs.hilt.compiler)

	// navigation
	implementation(libs.navigation.compose)
	implementation(libs.hilt.navigation.compose)

	// oribit
	implementation(libs.orbit.core)
	implementation(libs.orbit.viewmodel)
	implementation(libs.orbit.compose )

	// coil
	implementation(libs.coil)
	implementation(libs.coil.compose)

	// paging
	implementation(libs.paging.compose)

	testImplementation(libs.kotlinx.coroutines.test)
}