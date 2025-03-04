package com.jgeun.fastcampus.sns.app

import com.jgeun.fastcampus.sns.data.UserDataStore
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
@HiltAndroidTest
//@UninstallModules(FooModule::class)
class HiltExampleTest {

    @Inject
     lateinit var userDataStore: UserDataStore

     @get:Rule
     val hiltRule = HiltAndroidRule(this)

//    @Inject
//    lateinit var foo: Foo

    @BindValue
    val foo: Foo = Foo("HiltExampleTest")

    @Inject
    lateinit var bar: Bar

    @Test
    fun 주입테스트() {
        hiltRule.inject()
        Assert.assertNotNull(userDataStore)
    }

    @Test
    fun bar주입테스트() {
        hiltRule.inject()
        Assert.assertNotNull(bar)
        Assert.assertEquals("HiltExampleTest", bar.foo.tag)
    }

//    @Test
//    fun foo테스트() {
//        hiltRule.inject()
//        Assert.assertEquals("FakeFooModule", foo.tag)
//    }
}