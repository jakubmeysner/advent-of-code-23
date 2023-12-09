package com.jakubmeysner.adventofcode.y23.d08.p1

import java.nio.file.Files
import kotlin.io.path.Path

object HauntedWasteland {
    fun solution(lines: List<String>): Int {
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

        var nextInstructionIndex = 0
        var location = "AAA"
        var steps = 0

        while (location != "ZZZ") {
            val instructionIndex = nextInstructionIndex++
            nextInstructionIndex %= instructions.size
            steps++

            location = connections.getValue(location).let {
                if (instructions[instructionIndex] == 'L') it.first else it.second
            }
        }

        return steps
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d08.txt"))
        println(solution(lines))
    }
}
