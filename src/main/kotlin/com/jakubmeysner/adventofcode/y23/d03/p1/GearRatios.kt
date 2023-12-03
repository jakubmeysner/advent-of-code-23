package com.jakubmeysner.adventofcode.y23.d03.p1

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.math.max
import kotlin.math.min

object GearRatios {
    private fun getNeighborsCoordinates(
        y: Int,
        xFirst: Int,
        xLast: Int,
        yLastIndex: Int,
        xLastIndex: Int,
    ): List<Pair<Int, Int>> {
        val xRange = max(xFirst - 1, 0)..min(xLast + 1, xLastIndex)

        val top = if (y > 0) xRange.map { Pair(y - 1, it) } else emptyList()
        val bottom = if (y < yLastIndex) xRange.map { Pair(y + 1, it) } else emptyList()
        val left = if (xFirst > 0) listOf(Pair(y, xFirst - 1)) else emptyList()
        val right = if (xLast < xLastIndex) listOf(Pair(y, xLast + 1)) else emptyList()

        return top + bottom + left + right
    }

    fun solution(lines: List<String>): String {
        var sum = 0

        for (lineIndex in lines.indices) {
            val line = lines[lineIndex]
            var charIndex = 0

            while (charIndex < line.length) {
                if (line[charIndex].isDigit()) {
                    var lastDigitIndex = charIndex

                    while (
                        lastDigitIndex + 1 < line.length
                        && line[lastDigitIndex + 1].isDigit()
                    ) {
                        lastDigitIndex++
                    }

                    val number = line.substring(charIndex..lastDigitIndex).toInt()
                    val neighbors = getNeighborsCoordinates(
                        lineIndex, charIndex, lastDigitIndex, lines.lastIndex, line.lastIndex
                    )

                    if (
                        neighbors.any { (y, x) ->
                            val neighborChar = lines[y][x]
                            !neighborChar.isDigit() && neighborChar != '.'
                        }
                    ) {
                        sum += number
                    }

                    charIndex = lastDigitIndex + 1
                } else {
                    charIndex++
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
