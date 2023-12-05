package com.jakubmeysner.adventofcode.y23.d04.p1

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.math.pow

object Scratchcards {
    fun solution(lines: List<String>): String {
        return lines.sumOf { line ->
            val (winningNumbers, numbers) = line
                .substring(line.indexOf(": ") + 2)
                .split("""\s+\|\s+""".toRegex())
                .map { it.trim().split("""\s+""".toRegex()).map { it.toInt() }.toSet() }

            winningNumbers.intersect(numbers).size.let { intersectSize ->
                if (intersectSize != 0) 2.toDouble().pow(intersectSize - 1).toInt() else 0
            }
        }.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d04.txt"))
        println(solution(lines))
    }
}
