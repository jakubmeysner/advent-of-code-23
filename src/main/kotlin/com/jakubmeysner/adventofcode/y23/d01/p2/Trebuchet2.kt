package com.jakubmeysner.adventofcode.y23.d01.p2

import java.nio.file.Files
import kotlin.io.path.Path

private val digitWords = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
)

private val digitWordLengths = digitWords.keys.map { it.length }.toSet()

fun solution(input: List<String>): String {
    return input.sumOf { line ->
        val firstDigitIndex = line.indexOfFirst { it.isDigit() }
        val lastDigitIndex = line.indexOfLast { it.isDigit() }

        var firstWordLength = 0
        val firstWordIndex = line.indices.firstOrNull { i ->
            digitWordLengths.any { length ->
                if (i + length > line.length) {
                    return@any false
                }

                val word = line.substring(i..<i + length)

                if (digitWords.containsKey(word)) {
                    firstWordLength = length
                    true
                } else {
                    false
                }
            }
        }

        var lastWordLength = 0
        val lastWordIndex = line.indices.lastOrNull { i ->
            digitWordLengths.any { length ->
                if (i + length > line.length) {
                    return@any false
                }

                val word = line.substring(i..<i + length)

                if (digitWords.containsKey(word)) {
                    lastWordLength = length
                    true
                } else {
                    false
                }
            }
        }

        if (firstWordIndex == null || (firstDigitIndex != -1 && firstDigitIndex < firstWordIndex)) {
            line[firstDigitIndex].digitToInt()
        } else {
            digitWords.getValue(line.substring(firstWordIndex..<firstWordIndex + firstWordLength))
        } * 10 + if (lastWordIndex == null || (lastDigitIndex != -1 && lastDigitIndex > lastWordIndex)) {
            line[lastDigitIndex].digitToInt()
        } else {
            digitWords.getValue(line.substring(lastWordIndex..<lastWordIndex + lastWordLength))
        }
    }.toString()
}

fun main() {
    val input = Files.readAllLines(Path("./inputs/d01.txt"))
    println(solution(input))
}
