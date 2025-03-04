package com.jgeun.fastcampus.sns.app

import androidx.test.core.app.ApplicationProvider
import com.jgeun.fastcampus.sns.data.UserDataStore
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class RobolectricWithHiltTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var userDataStore: UserDataStore

    @Test
    fun 첫번째_테스트() {
        hiltRule.inject()
        Assert.assertNotNull(userDataStore)
    }

    @Test
    fun foo접근_테스트() {
        val application = ApplicationProvider.getApplicationContext<HiltTestApplication>()
        Assert.assertNotNull(application)

        val entryPoint = EntryPointAccessors.fromApplication(application.applicationContext, FooEntryPoint::class.java)
        Assert.assertEquals("FooModule", entryPoint.foo().tag)
    }
}