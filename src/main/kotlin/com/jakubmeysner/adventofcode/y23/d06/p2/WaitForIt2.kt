package com.jakubmeysner.adventofcode.y23.d06.p2

import java.nio.file.Files
import kotlin.io.path.Path

object WaitForIt2 {
    private fun calculateDistance(time: Long, chargeTime: Long): Long {
        return (time - chargeTime) * chargeTime
    }

    fun solution(lines: List<String>): String {
        val time = lines[0].filter { it.isDigit() }.toLong()
        val recordDistance = lines[1].filter { it.isDigit() }.toLong()

        return (1..<time).count {
            calculateDistance(time, it) > recordDistance
        }.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d06.txt"))
        println(solution(lines))
    }
}
