package com.jakubmeysner.adventofcode.y23.d09.p2

import java.nio.file.Files
import kotlin.io.path.Path

object MirageMaintenance2 {
    fun predictPreviousValue(values: List<Int>): Int {
        if (values.all { it == 0 }) {
            return 0
        }

        val previous = predictPreviousValue(values.zipWithNext().map { (a, b) -> b - a })
        return values.first() - previous
    }

    fun solution(lines: List<String>): Int {
        return lines.sumOf { line ->
            val values = line.split(' ').map { it.toInt() }
            predictPreviousValue(values)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d09.txt"))
        println(solution(lines))
    }
}
