package com.jgeun.fastcampus.sns.domain.qualifier

import javax.inject.Qualifier

/**
 *
 * @author   JGeun
 * @created  2025/03/01
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Default

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Hilt