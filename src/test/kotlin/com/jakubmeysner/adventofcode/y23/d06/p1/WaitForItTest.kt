package com.jakubmeysner.adventofcode.y23.d06.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaitForItTest {
    @Test
    fun solution() {
        assertEquals(
            "288",
            WaitForIt.solution(
                """
                    Time:      7  15   30
                    Distance:  9  40  200
                """.trimIndent().lines()
            )
        )
    }
}
