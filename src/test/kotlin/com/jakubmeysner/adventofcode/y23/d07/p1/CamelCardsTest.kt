package com.jakubmeysner.adventofcode.y23.d07.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CamelCardsTest {
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
        )

        assertEquals(expected, expected.keys.associateWith { CamelCards.handType(it) })
    }

    @Test
    fun compareHands() {
        assertTrue(CamelCards.compareHands("AAAAA", "AA8AA") > 0)
        assertTrue(CamelCards.compareHands("TTT98", "23332") < 0)
        assertEquals(0, CamelCards.compareHands("23432", "23432"))

        assertTrue(CamelCards.compareHands("33332", "2AAAA") > 0)
        assertTrue(CamelCards.compareHands("77788", "77888") < 0)
    }

    @Test
    fun solution() {
        assertEquals(
            "6440",
            CamelCards.solution(
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
