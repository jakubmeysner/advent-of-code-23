package com.jakubmeysner.adventofcode.y23.d04.p2

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.math.min

object Scratchcards {
    fun solution(lines: List<String>): String {
        val copies = lines.indices.associateWith { 1 }.toMutableMap()

        for (lineIndex in lines.indices) {
            val line = lines[lineIndex]

            val (winningNumbers, numbers) = line
                .substring(line.indexOf(": ") + 2)
                .split("""\s+\|\s+""".toRegex())
                .map { it.trim().split("""\s+""".toRegex()).map { it.toInt() }.toSet() }

            val intersectSize = winningNumbers.intersect(numbers).size

            for (i in lineIndex + 1..min(lineIndex + intersectSize, lines.lastIndex)) {
                copies[i] = copies[i]!! + copies[lineIndex]!!
            }
        }

        return copies.values.sum().toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d04.txt"))
        println(solution(lines))
    }
}
