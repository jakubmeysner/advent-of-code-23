package com.jakubmeysner.adventofcode.y23.d08.p2

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.math.absoluteValue

object HauntedWasteland2 {
    private fun greatestCommonDivisor(number1: Long, number2: Long): Long {
        var a = number1
        var b = number2

        while (b != 0L) {
            val temp = b
            b = a % b
            a = temp
        }

        return a
    }

    private fun leastCommonMultiple(number1: Long, number2: Long): Long {
        return number1.absoluteValue * (number2.absoluteValue / greatestCommonDivisor(number1, number2))
    }

    fun solution(lines: List<String>): Long {
        val instructions = lines[0].toCharArray()

        val connections = lines
            .subList(2, lines.size)
            .associate {
                Pair(
                    it.substring(0, it.indexOf(' ')),
                    Pair(
                        it.substring(it.indexOf('(') + 1, it.indexOf(',')),
                        it.substring(it.lastIndexOf(' ') + 1, it.indexOf(')'))
                    )
                )
            }

        val initialLocations = connections.keys.filter { it.endsWith('A') }

        return initialLocations.map { initialLocation ->
            var nextInstructionIndex = 0
            var location = initialLocation
            var steps = 0L

            while (!location.endsWith('Z')) {
                val instructionIndex = nextInstructionIndex++
                nextInstructionIndex %= instructions.size
                steps++

                location = connections.getValue(location).let {
                    if (instructions[instructionIndex] == 'L') it.first else it.second
                }
            }

            steps
        }.reduce(::leastCommonMultiple)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d08.txt"))
        println(solution(lines))
    }
}
