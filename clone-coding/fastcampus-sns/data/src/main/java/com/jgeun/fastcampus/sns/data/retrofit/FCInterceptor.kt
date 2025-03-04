package com.jgeun.fastcampus.sns.data.retrofit

import com.jgeun.fastcampus.sns.data.UserDataStore
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/22
 */
class FCInterceptor @Inject constructor(
	private val userDataStore: UserDataStore
) : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		val token: String? = runBlocking { userDataStore.getToken() }

		return chain.proceed(
			chain.request()
				.newBuilder()
				.run {
					if (token.isNullOrEmpty()) {
						this
					} else {
						this.addHeader("Token", token)
					}
				}
				.addHeader("Content-Type","application/json; charset=UTF8")
				.build()
		)
	}
}