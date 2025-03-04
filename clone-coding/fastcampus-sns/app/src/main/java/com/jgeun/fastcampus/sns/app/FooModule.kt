package com.jgeun.fastcampus.sns.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
@Module
@InstallIn(SingletonComponent::class)
class FooModule {

    @Provides
    fun provideFoo(): Foo {
        return Foo("FooModule")
    }
}

class Foo(val tag: String)

class Bar @Inject constructor(val foo: Foo)