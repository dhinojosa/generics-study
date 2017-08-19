package com.xyzcorp

import kotlin.test.assertEquals
import org.junit.Test as test

class KotlinBoxTest {
    @test
    fun testBox() {
        val kotlinBox = KotlinBox(4)
        val newKotlinBox = kotlinBox.map { x -> x + 10 }
        assertEquals(newKotlinBox.t, 14);
    }
}