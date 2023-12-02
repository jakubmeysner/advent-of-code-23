package com.jakubmeysner.adventofcode.y23.d02.p2

import java.nio.file.Files
import kotlin.io.path.Path

fun solution(input: List<String>): String {
    return input.sumOf {
        val (_, setsString) = it.split(": ")
        val sets = setsString.split("; ")

        val cubes = mutableMapOf<String, Int>()

        for (set in sets) {
            for (element in set.split(", ")) {
                val (countString, color) = element.split(" ")
                val count = countString.toInt()

                if (count > cubes.getOrDefault(color, 0)) {
                    cubes[color] = count
                }
            }
        }

        cubes.values.reduce { acc, i -> acc * i }
    }.toString()
}

fun main() {
    val input = Files.readAllLines(Path("./inputs/d02.txt"))
    println(solution(input))
}
