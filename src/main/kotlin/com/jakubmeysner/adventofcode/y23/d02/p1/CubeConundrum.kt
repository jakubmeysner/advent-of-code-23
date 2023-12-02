package com.jakubmeysner.adventofcode.y23.d02.p1

import java.nio.file.Files
import kotlin.io.path.Path

private val cubes = mapOf(
    "red" to 12,
    "green" to 13,
    "blue" to 14,
)

fun solution(input: List<String>): String {
    return input.sumOf {
        val (game, setsString) = it.split(": ")
        val gameId = game.substring("Game ".length).toInt()
        val sets = setsString.split("; ")

        for (set in sets) {
            for (element in set.split(", ")) {
                val (countString, color) = element.split(" ")
                val count = countString.toInt()

                if (count > cubes.getValue(color)) {
                    return@sumOf 0
                }
            }
        }

        gameId
    }.toString()
}

fun main() {
    val input = Files.readAllLines(Path("./inputs/d02.txt"))
    println(solution(input))
}
