package com.jakubmeysner.adventofcode.y23.d07.p2

import java.nio.file.Files
import kotlin.io.path.Path

object CamelCards2 {
    private val charCountsValues = mapOf(
        listOf(1, 1, 1, 1, 1) to 0,
        listOf(2, 1, 1, 1) to 1,
        listOf(2, 2, 1) to 2,
        listOf(3, 1, 1) to 3,
        listOf(3, 2) to 4,
        listOf(4, 1) to 5,
        listOf(5) to 6,
    )

    fun handType(hand: String): Int {
        val charCounts = hand
            .filter { it != 'J' }
            .groupingBy { it }
            .eachCount()
            .values
            .sortedDescending()

        val charCountsSum = charCounts.sum()

        return charCountsValues.getValue(
            if (charCounts.isEmpty()) listOf(5)
            else charCounts.mapIndexed { index, i ->
                if (index == 0) i + 5 - charCountsSum
                else i
            }
        )
    }

    private val handChars = listOf(
        'J', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A'
    )

    fun compareHands(hand1: String, hand2: String): Int {
        val handType1 = handType(hand1)
        val handType2 = handType(hand2)

        if (handType1 != handType2) {
            return handType1.compareTo(handType2)
        }

        for (i in hand1.indices) {
            val strength1 = handChars.indexOf(hand1[i])
            val strength2 = handChars.indexOf(hand2[i])

            if (strength1 != strength2) {
                return strength1.compareTo(strength2)
            }
        }

        return 0
    }

    fun solution(lines: List<String>): String {
        return lines
            .map {
                val (hand, strengthStr) = it.split(' ')
                Pair(hand, strengthStr.toInt())
            }
            .sortedWith { (hand1), (hand2) -> compareHands(hand1, hand2) }
            .mapIndexed { index, (_, strength) -> (index + 1) * strength }
            .sum()
            .toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d07.txt"))
        println(solution(lines))
    }
}
