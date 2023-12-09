package com.jakubmeysner.adventofcode.y23.d08.p2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HauntedWasteland2Test {
    @Test
    fun solution() {
        assertEquals(
            6,
            HauntedWasteland2.solution(
                """
                    LR

                    11A = (11B, XXX)
                    11B = (XXX, 11Z)
                    11Z = (11B, XXX)
                    22A = (22B, XXX)
                    22B = (22C, 22C)
                    22C = (22Z, 22Z)
                    22Z = (22B, 22B)
                    XXX = (XXX, XXX)
                """.trimIndent().lines()
            )
        )
    }
}
