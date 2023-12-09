package com.jakubmeysner.adventofcode.y23.d08.p1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HauntedWastelandTest {
    @Test
    fun solution() {
        assertEquals(
            2,
            HauntedWasteland.solution(
                """
                    RL

                    AAA = (BBB, CCC)
                    BBB = (DDD, EEE)
                    CCC = (ZZZ, GGG)
                    DDD = (DDD, DDD)
                    EEE = (EEE, EEE)
                    GGG = (GGG, GGG)
                    ZZZ = (ZZZ, ZZZ)
                """.trimIndent().lines()
            )
        )

        assertEquals(
            6,
            HauntedWasteland.solution(
                """
                    LLR

                    AAA = (BBB, BBB)
                    BBB = (AAA, ZZZ)
                    ZZZ = (ZZZ, ZZZ)
                """.trimIndent().lines()
            )
        )
    }
}
