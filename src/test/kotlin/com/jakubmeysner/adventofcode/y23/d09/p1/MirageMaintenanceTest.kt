package com.jakubmeysner.adventofcode.y23.d09.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MirageMaintenanceTest {
    @Test
    fun predictNextValue() {
        val expected = mapOf(
            listOf(0, 3, 6, 9, 12, 15) to 18,
            listOf(1, 3, 6, 10, 15, 21) to 28,
            listOf(10, 13, 16, 21, 30, 45) to 68,
        )

        assertEquals(
            expected,
            expected.keys.associateWith { MirageMaintenance.predictNextValue(it) }
        )
    }

    @Test
    fun solution() {
        assertEquals(
            114,
            MirageMaintenance.solution(
                """
                    0 3 6 9 12 15
                    1 3 6 10 15 21
                    10 13 16 21 30 45
                """.trimIndent().lines()
            )
        )
    }
}
