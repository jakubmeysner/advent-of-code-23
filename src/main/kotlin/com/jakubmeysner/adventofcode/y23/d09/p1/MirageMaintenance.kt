package com.jakubmeysner.adventofcode.y23.d09.p1

import java.nio.file.Files
import kotlin.io.path.Path

object MirageMaintenance {
    fun predictNextValue(values: List<Int>): Int {
        if (values.all { it == 0 }) {
            return 0
        }

        val next = predictNextValue(values.zipWithNext().map { (a, b) -> b - a })
        return values.last() + next
    }

    fun solution(lines: List<String>): Int {
        return lines.sumOf { line ->
            val values = line.split(' ').map { it.toInt() }
            predictNextValue(values)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d09.txt"))
        println(solution(lines))
    }
}
