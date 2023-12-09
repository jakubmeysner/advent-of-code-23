package com.jakubmeysner.adventofcode.y23.d07.p2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CamelCards2Test {
    @Test
    fun handType() {
        val expected = mapOf(
            "AAAAA" to 6,
            "AA8AA" to 5,
            "23332" to 4,
            "TTT98" to 3,
            "23432" to 2,
            "A23A4" to 1,
            "23456" to 0,
            "QJJQ2" to 5,
            "T55J5" to 5,
            "KTJJT" to 5,
            "QQQJA" to 5,
            "JJJJJ" to 6,
        )

        assertEquals(expected, expected.keys.associateWith { CamelCards2.handType(it) })
    }

    @Test
    fun compareHands() {
        assertTrue(CamelCards2.compareHands("JKKK2", "QQQQ2") < 0)
        assertTrue(CamelCards2.compareHands("T55J5", "QQQJA") < 0)
    }

    @Test
    fun solution() {
        assertEquals(
            "5905",
            CamelCards2.solution(
                """
                    32T3K 765
                    T55J5 684
                    KK677 28
                    KTJJT 220
                    QQQJA 483
                """.trimIndent().lines()
            )
        )
    }
}
