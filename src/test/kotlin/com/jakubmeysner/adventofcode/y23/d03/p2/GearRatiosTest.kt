package com.jakubmeysner.adventofcode.y23.d03.p2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class GearRatiosTest {
    @Test
    fun solution() {
        assertEquals(
            "467835",
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
