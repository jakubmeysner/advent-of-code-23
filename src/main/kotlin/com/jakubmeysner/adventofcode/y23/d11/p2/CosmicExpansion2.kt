package com.jakubmeysner.adventofcode.y23.d11.p2

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.math.max
import kotlin.math.min

object CosmicExpansion2 {
    fun solution(lines: List<String>): Long {
        val galaxies = mutableListOf<Pair<Int, Int>>()
        val galaxiesRows = mutableSetOf<Int>()
        val galaxiesCols = mutableSetOf<Int>()

        for (y in lines.indices) {
            for (x in lines[0].indices) {
                if (lines[y][x] == '#') {
                    galaxies.add(Pair(y, x))
                    galaxiesRows.add(y)
                    galaxiesCols.add(x)
                }
            }
        }

        return galaxies.mapIndexed { index, (y1, x1) ->
            galaxies.subList(index + 1, galaxies.size).sumOf { (y2, x2) ->
                var distance = if (y1 != y2 && x1 != x2) 2L else 1

                if (y1 != y2) {
                    for (y in min(y1, y2) + 1..<max(y1, y2)) {
                        if (galaxiesRows.contains(y)) {
                            distance++
                        } else {
                            distance += 1000000
                        }
                    }
                }

                if (x1 != x2) {
                    for (x in min(x1, x2) + 1..<max(x1, x2)) {
                        if (galaxiesCols.contains(x)) {
                            distance++
                        } else {
                            distance += 1000000
                        }
                    }
                }

                distance
            }
        }.sum()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d11.txt"))
        println(solution(lines))
    }
}
