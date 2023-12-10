package com.jakubmeysner.adventofcode.y23.d10.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PipeMazeTest {
    @Test
    fun solution() {
        val expected = mapOf(
            """
                .....
                .S-7.
                .|.|.
                .L-J.
                .....
            """.trimIndent().lines() to 4,
            """
                ..F7.
                .FJ|.
                SJ.L7
                |F--J
                LJ...
            """.trimIndent().lines() to 8,
        )

        assertEquals(expected, expected.keys.associateWith { PipeMaze.solution(it) })
    }
}
