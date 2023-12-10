package com.jakubmeysner.adventofcode.y23.d09.p2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MirageMaintenance2Test {
    @Test
    fun predictPreviousValue() {
        assertEquals(
            5,
            MirageMaintenance2.predictPreviousValue(listOf(10, 13, 16, 21, 30, 45))
        )
    }

    @Test
    fun solution() {
        assertEquals(
            2,
            MirageMaintenance2.solution(
                """
                    0 3 6 9 12 15
                    1 3 6 10 15 21
                    10 13 16 21 30 45
                """.trimIndent().lines()
            )
        )
    }
}
