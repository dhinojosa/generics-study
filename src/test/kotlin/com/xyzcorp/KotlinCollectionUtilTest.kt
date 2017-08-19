package com.xyzcorp

import kotlin.test.assertEquals
import org.junit.Test as test

class KotlinCollectionUtilTest {
    @test
    fun testBox() {
        val list: List<Int> = listOf(4, 2, 1, 5)
        val result: Int? = KotlinCollectionUtil.myMax(list)
        assertEquals(result ?: -1, 5)
    }
}