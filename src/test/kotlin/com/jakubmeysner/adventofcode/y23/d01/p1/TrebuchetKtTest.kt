package com.jakubmeysner.adventofcode.y23.d01.p1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TrebuchetKtTest {
    @Test
    fun solution() {
        assertEquals(
            "142",
            solution(
                """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """.trimIndent().lines()
            )
        )
    }
}
