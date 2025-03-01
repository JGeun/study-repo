package com.jgeun.fastcampus.sns.hiltextension.app

import com.jgeun.fastcampus.sns.hiltextension.annotations.InstallBinding
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

/**
 * @author   JGeun
 * @created  2025/03/01
 */
@InstallBinding(component = SingletonComponent::class)
class AuthenticatorImpl @Inject constructor(): Authenticator