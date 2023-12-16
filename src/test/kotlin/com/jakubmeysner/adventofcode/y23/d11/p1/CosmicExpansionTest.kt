package com.jakubmeysner.adventofcode.y23.d11.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CosmicExpansionTest {
    @Test
    fun solution() {
        assertEquals(
            374,
            CosmicExpansion.solution(
                """
                    ...#......
                    .......#..
                    #.........
                    ..........
                    ......#...
                    .#........
                    .........#
                    ..........
                    .......#..
                    #...#.....
                """.trimIndent().lines()
            )
        )
    }
}
