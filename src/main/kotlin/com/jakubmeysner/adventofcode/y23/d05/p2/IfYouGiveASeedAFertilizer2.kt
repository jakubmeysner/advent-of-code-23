package com.jakubmeysner.adventofcode.y23.d05.p2

import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.math.max
import kotlin.math.min

object IfYouGiveASeedAFertilizer2 {
    private fun minLocation(
        mappings: Map<String, MutableMap<LongRange, Long>>,
        mappingDestinations: Map<String, String>,
        range: LongRange,
        sourceCategory: String,
    ): Long {
        if (sourceCategory == "location") {
            return range.first
        }

        val ranges = mappings
            .getValue(sourceCategory)
            .filter { max(it.key.first, range.first) <= min(it.key.last, range.last) }
            .toList()
            .sortedBy { it.first.first }
            .toMutableList()

        if (ranges.isEmpty()) {
            ranges.add(Pair(range, 0))
        } else {
            val (firstRange, firstDifference) = ranges[0]

            if (firstRange.first < range.first) {
                ranges[0] = Pair(range.first..firstRange.last, firstDifference)
            } else if (firstRange.first > range.first) {
                ranges.add(0, Pair(range.first..<firstRange.first, 0))
            }

            val (lastRange, lastDifference) = ranges.last()

            if (lastRange.last > range.last) {
                ranges[ranges.lastIndex] = Pair(lastRange.first..range.last, lastDifference)
            } else if (lastRange.last < range.last) {
                ranges.add(Pair(lastRange.last + 1..range.last, 0))
            }
        }

        var i = 1

        while (i < ranges.size) {
            val (previousRange) = ranges[i - 1]
            val (thisRange) = ranges[i]

            if (previousRange.last + 1 < thisRange.first) {
                ranges.add(Pair(previousRange.last + 1..<thisRange.first, 0))
                i++
            }

            i++
        }

        return ranges.minOf { (range, difference) ->
            minLocation(
                mappings,
                mappingDestinations,
                range.first + difference..range.last + difference,
                mappingDestinations.getValue(sourceCategory)
            )
        }
    }

    fun solution(lines: List<String>): String {
        val seeds = lines
            .first()
            .substring("seeds: ".length)
            .split(' ')
            .map { it.toLong() }
            .chunked(2)
            .map { (start, length) -> start..<start + length }

        val mappings = mutableMapOf<String, MutableMap<LongRange, Long>>()
        val mappingDestinations = mutableMapOf<String, String>()

        var currentSource = "seed"
        var currentDestination = "soil"

        for (line in lines.subList(2, lines.size)) {
            if (line.endsWith("map:")) {
                currentSource = line.substring(0, line.indexOf('-'))
                currentDestination = line.substring(line.lastIndexOf('-') + 1, line.lastIndexOf(' '))
            } else if (line.isNotEmpty()) {
                mappings.putIfAbsent(currentSource, mutableMapOf())
                mappingDestinations.putIfAbsent(currentSource, currentDestination)

                val mapping = mappings.getValue(currentSource)
                val (destinationStart, sourceStart, length) = line.split(' ').map { it.toLong() }
                mapping[sourceStart..<sourceStart + length] = destinationStart - sourceStart
            }
        }

        return seeds.minOf {
            minLocation(mappings, mappingDestinations, it, "seed")
        }.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d05.txt"))
        println(solution(lines))
    }
}
