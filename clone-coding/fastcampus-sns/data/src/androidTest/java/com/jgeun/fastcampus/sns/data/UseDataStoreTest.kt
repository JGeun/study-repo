package com.jgeun.fastcampus.sns.data

import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.math.exp

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
class UseDataStoreTest {

    @Test
    fun 토큰_저장_테스트() = runTest {
        // given
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val userDataStore = UserDataStore(context)
        val expectedToken = "abc123"

        // when
        userDataStore.setToken(expectedToken)

        // then
        val actualToken = userDataStore.getToken()
        Assert.assertEquals(expectedToken, actualToken)

        // when
        userDataStore.clear()

        // then
        val actualToken2 = userDataStore.getToken()
        Assert.assertNotEquals(expectedToken, actualToken2)
        Assert.assertNull(null, actualToken2)
    }
}