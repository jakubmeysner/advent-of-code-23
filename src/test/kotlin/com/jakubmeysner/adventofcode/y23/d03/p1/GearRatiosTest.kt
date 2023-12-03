package com.jakubmeysner.adventofcode.y23.d03.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GearRatiosTest {
    @Test
    fun solution() {
        assertEquals(
            "4361",
            GearRatios.solution(
                """
                    467..114..
                    ...*......
                    ..35..633.
                    ......#...
                    617*......
                    .....+.58.
                    ..592.....
                    ......755.
                    ...${'$'}.*....
                    .664.598..
                """.trimIndent().lines()
            )
        )
    }
}
