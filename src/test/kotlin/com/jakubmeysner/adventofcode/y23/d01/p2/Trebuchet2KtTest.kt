package com.jakubmeysner.adventofcode.y23.d01.p2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Trebuchet2KtTest {
    @Test
    fun solution() {
        assertEquals(
            "281",
            solution(
                """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                """.trimIndent().lines()
            )
        )
    }
}
