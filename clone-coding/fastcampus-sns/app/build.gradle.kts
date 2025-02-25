plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.compose.compiler)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.hilt)
	id("kotlin-kapt")
}

android {
	namespace = "com.jgeun.fastcampus.sns.app"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.jgeun.fastcampus.sns.app"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "com.jgeun.fastcampus.sns.app.CustomRunner"
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
		kotlinCompilerExtensionVersion = "1.5.6"
	}
	kapt {
		correctErrorTypes = true
	}
}

composeCompiler {
	reportsDestination = layout.buildDirectory.dir("compose_compiler")
	stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}

dependencies {
	implementation(project(":clone-coding:fastcampus-sns:presentation"))
	implementation(project(":clone-coding:fastcampus-sns:domain"))
	implementation(project(":clone-coding:fastcampus-sns:data"))

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

	implementation(libs.datastore)

	implementation(libs.retrofit)
	implementation(libs.retrofit.converter.serialization)

	implementation(libs.kotlinx.serialization.json)
	implementation(libs.okhttp)

	implementation(libs.hilt)
	kapt(libs.hilt.compiler)

	// For instrumented tests.
	androidTestImplementation(libs.hilt.android.testing)
	// ...with Kotlin.
	kaptAndroidTest(libs.hilt.compiler)
}