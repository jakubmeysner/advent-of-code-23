package com.jakubmeysner.adventofcode.y23.d06.p2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaitForIt2Test {
    @Test
    fun solution() {
        assertEquals(
            "71503",
            WaitForIt2.solution(
                """
                    Time:      7  15   30
                    Distance:  9  40  200
                """.trimIndent().lines()
            )
        )
    }
}
