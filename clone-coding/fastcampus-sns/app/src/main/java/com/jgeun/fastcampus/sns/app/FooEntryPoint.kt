package com.jgeun.fastcampus.sns.app

import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
@EntryPoint
@InstallIn(SingletonComponent::class)
interface FooEntryPoint {

    fun foo(): Foo
}