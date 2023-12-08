package com.jakubmeysner.adventofcode.y23.d05.p1

import java.nio.file.Files
import kotlin.io.path.Path

object IfYouGiveASeedAFertilizer {
    fun solution(lines: List<String>): String {
        val seeds = lines[0].substring("seeds: ".length).split(" ").map { it.toLong() }
        val mappings = mutableMapOf<String, MutableMap<LongRange, Long>>()
        val mappingDestinations = mutableMapOf<String, String>()
        var currentSource = "seed"
        var currentDestination = "soil"

        for (line in lines.subList(3, lines.size)) {
            if (line.endsWith(" map:")) {
                currentSource = line.substring(0, line.indexOf('-'))
                currentDestination = line.substring(line.lastIndexOf('-') + 1, line.lastIndexOf(' '))
            } else if (line.isNotBlank()) {
                if (!mappings.containsKey(currentSource)) {
                    mappings[currentSource] = mutableMapOf()
                }

                if (!mappingDestinations.containsKey(currentSource)) {
                    mappingDestinations[currentSource] = currentDestination
                }

                val mapping = mappings.getValue(currentSource)
                val (destinationStart, sourceStart, length) = line.split(' ').map { it.toLong() }
                mapping[sourceStart..<sourceStart + length] = destinationStart - sourceStart
            }
        }

        return seeds.minOf {
            var currentCategory = "seed"
            var currentNumber = it

            while (currentCategory != "location") {
                val mapping = mappings.getValue(currentCategory)
                val range = mapping.keys.find { currentNumber in it }
                currentCategory = mappingDestinations.getValue(currentCategory)

                if (range != null) {
                    val difference = mapping.getValue(range)
                    currentNumber += difference
                }
            }

            currentNumber
        }.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d05.txt"))
        println(solution(lines))
    }
}
