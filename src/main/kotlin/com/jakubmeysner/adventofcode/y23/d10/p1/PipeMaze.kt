package com.jakubmeysner.adventofcode.y23.d10.p1

import java.nio.file.Files
import kotlin.io.path.Path

object PipeMaze {
    private data class Position(val y: Int, val x: Int) {
        fun next(direction: Direction): Position {
            return Position(y + direction.deltaY, x + direction.deltaX)
        }
    }

    private enum class Direction(val deltaY: Int, val deltaX: Int) {
        NORTH(-1, 0),
        SOUTH(1, 0),
        WEST(0, -1),
        EAST(0, 1);

        val opposite: Direction
            get() {
                return when (this) {
                    NORTH -> SOUTH
                    SOUTH -> NORTH
                    WEST -> EAST
                    EAST -> WEST
                }
            }
    }

    private const val STARTING_CHAR = 'S'

    private val pipes = mapOf(
        '|' to setOf(Direction.NORTH, Direction.SOUTH),
        '-' to setOf(Direction.WEST, Direction.EAST),
        'L' to setOf(Direction.NORTH, Direction.EAST),
        'J' to setOf(Direction.NORTH, Direction.WEST),
        '7' to setOf(Direction.SOUTH, Direction.WEST),
        'F' to setOf(Direction.SOUTH, Direction.EAST),
    )

    private fun path(grid: List<CharArray>, startingPosition: Position, startingDirection: Direction): List<Position>? {
        val positions = mutableListOf(startingPosition)
        var direction = startingDirection

        do {
            val position = positions.last().next(direction)

            if (positions.size > 1 && position == startingPosition) {
                positions.add(position)
                break
            }

            val contents = grid.getOrNull(position.y)?.getOrNull(position.x) ?: return null
            val directions = pipes[contents] ?: return null

            if (!directions.contains(direction.opposite)) {
                return null
            }

            positions.add(position)
            direction = directions.minus(direction.opposite).first()
        } while (positions.last() != startingPosition)

        return positions
    }

    fun solution(lines: List<String>): Int {
        val grid = lines.map { it.toCharArray() }

        val startingY = grid.indexOfFirst { it.contains(STARTING_CHAR) }
        val startingPosition = Position(startingY, grid[startingY].indexOf(STARTING_CHAR))

        val paths = Direction.entries.mapNotNull { path(grid, startingPosition, it) }

        return paths.maxOfOrNull { it.size / 2 } ?: -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = Files.readAllLines(Path("./inputs/d10.txt"))
        println(solution(lines))
    }
}
