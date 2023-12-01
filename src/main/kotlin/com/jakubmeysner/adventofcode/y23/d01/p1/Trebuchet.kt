package com.jakubmeysner.adventofcode.y23.d01.p1

import java.nio.file.Files
import kotlin.io.path.Path

fun solution(input: List<String>): String {
    return input.sumOf { line ->
        val firstDigit = line.first { it.isDigit() }
        val lastDigit = line.last { it.isDigit() }
        firstDigit.digitToInt() * 10 + lastDigit.digitToInt()
    }.toString()
}

fun main() {
    val input = Files.readAllLines(Path("./inputs/d01.txt"))
    println(solution(input))
}
