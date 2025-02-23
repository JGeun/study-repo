package com.jgeun.fastcampus.sns.data.di

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jgeun.fastcampus.sns.data.constant.FC_HOST
import com.jgeun.fastcampus.sns.data.retrofit.BoardService
import com.jgeun.fastcampus.sns.data.retrofit.FCInterceptor
import com.jgeun.fastcampus.sns.data.retrofit.FileService
import com.jgeun.fastcampus.sns.data.retrofit.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 *
 * @author JGeun
 * @created 2025/02/17
 *
 **/

/**
 *  *[FC_HOST]** 는 로컬 IP 서버 주소를 가리킵니다.
 *  개인 정보 보호를 위해 **직접 생성 후 기입**해주세요.
 **/

// const val FC_HOST = "http://123.456.123.14:8080

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

	@Provides
	fun provideOkHttpClient(interceptor: FCInterceptor): OkHttpClient {
		return OkHttpClient
			.Builder()
			.addInterceptor(interceptor)
			.addNetworkInterceptor(
				HttpLoggingInterceptor { message ->
					Log.w("Network Response", message)
				}.apply {
					level = HttpLoggingInterceptor.Level.BODY
				}
			)
			.build()
	}

	@Provides
	fun provideRetrofit(client: OkHttpClient): Retrofit {

		val json = Json {
			ignoreUnknownKeys = true
			coerceInputValues = true
			isLenient = true
			prettyPrint = true
		}

		val converterFactory = json.asConverterFactory("application/json; charset=UTF8".toMediaType())

		return Retrofit.Builder()
			.baseUrl("${FC_HOST}/api/")
			.addConverterFactory(converterFactory)
			.client(client)
			.build()
	}

	@Provides
	fun provideUserService(retrofit: Retrofit): UserService {
		return retrofit.create(UserService::class.java)
	}

	@Provides
	fun provideFileService(retrofit: Retrofit): FileService {
		return retrofit.create(FileService::class.java)
	}

	@Provides
	fun provideBoardService(retrofit: Retrofit): BoardService {
		return retrofit.create(BoardService::class.java)
	}
}