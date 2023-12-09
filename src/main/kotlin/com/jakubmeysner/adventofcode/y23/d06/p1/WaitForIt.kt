package com.jakubmeysner.adventofcode.y23.d06.p1

import java.nio.file.Files
import kotlin.io.path.Path

object WaitForIt {
    private fun extractNumbers(string: String): List<Int> {
        return string
            .substring(string.indexOf(' '))
            .trim()
            .split(""" +""".toRegex())
            .map { it.toInt() }
    }

    fun solution(lines: List<String>): String {
        val times = extractNumbers(lines[0])
        val recordDistances = extractNumbers(lines[1])

        return times.zip(recordDistances).map { (time, recordDistance) ->
            (1..<time).count {
                (time - it) * it > recordDistance
            }
        }.reduce { acc, i -> acc * i }.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d06.txt"))
        println(solution(lines))
    }
}
