package com.jakubmeysner.adventofcode.y23.d03.p2

import java.nio.file.Files
import kotlin.io.path.Path

object GearRatios {
    private fun getNumbers(lines: List<String>, y: Int, x: Int): List<Int> {
        return if (lines[y][x].isDigit()) {
            val startIndex = lines[y].substring(0..x).indexOfLast { !it.isDigit() } + 1
            val endIndex = lines[y].substring(x).indexOfFirst { !it.isDigit() }
                .let { if (it != -1) it - 1 + x else lines[y].lastIndex }
            listOf(lines[y].substring(startIndex..endIndex).toInt())
        } else {
            if (x > 0 && lines[y][x - 1].isDigit()) {
                val startIndex = lines[y].substring(0..<x).indexOfLast { !it.isDigit() } + 1
                listOf(lines[y].substring(startIndex..<x).toInt())
            } else {
                emptyList()
            } + if (x < lines[y].lastIndex && lines[y][x + 1].isDigit()) {
                val endIndex = lines[y].substring(x + 1).indexOfFirst { !it.isDigit() }
                    .let { if (it != -1) it - 1 + x + 1 else lines[y].lastIndex }
                listOf(lines[y].substring(x + 1..endIndex).toInt())
            } else {
                emptyList()
            }
        }
    }

    private fun getAdjacentNumbers(lines: List<String>, y: Int, x: Int): List<Int> {
        val left = if (x > 0 && lines[y][x - 1].isDigit()) {
            val startIndex = lines[y].substring(0..<x).indexOfLast { !it.isDigit() } + 1
            listOf(lines[y].substring(startIndex..<x).toInt())
        } else {
            emptyList()
        }

        val right = if (x < lines[y].lastIndex && lines[y][x + 1].isDigit()) {
            val endIndex = lines[y].substring(x + 1).indexOfFirst { !it.isDigit() }
                .let { if (it != -1) it - 1 + x + 1 else lines[y].lastIndex }
            listOf(lines[y].substring(x + 1..endIndex).toInt())
        } else {
            emptyList()
        }

        val top = if (y > 0) getNumbers(lines, y - 1, x) else emptyList()
        val bottom = if (y < lines.lastIndex) getNumbers(lines, y + 1, x) else emptyList()

        return left + right + top + bottom
    }

    fun solution(lines: List<String>): String {
        var sum = 0

        for (lineIndex in lines.indices) {
            val line = lines[lineIndex]

            for (charIndex in line.indices) {
                val char = line[charIndex]

                if (char != '*') {
                    continue
                }

                val adjacentNumbers = getAdjacentNumbers(lines, lineIndex, charIndex)

                if (adjacentNumbers.size == 2) {
                    sum += adjacentNumbers[0] * adjacentNumbers[1]
                }
            }
        }

        return sum.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d03.txt"))
        println(solution(lines))
    }
}
