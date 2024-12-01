package day1

import kotlin.math.abs

class Day1 {
    companion object {
        fun part1(): Int {
            val (list1, list2) = getLocations()
            return list1.sorted().zip(list2.sorted()).sumOf { (a, b) -> abs(a - b) }
        }

        fun part2(): Int {
            val (list1, list2) = getLocations()
            val occurrences = list2.groupingBy { it }.eachCount().toMutableMap()
            return list1.sumOf { it * occurrences.getOrDefault(it, 0) }
        }

        private fun getLocations(): Pair<List<Int>, List<Int>> {
            return this::class.java.getResourceAsStream("input.txt")!!
                .bufferedReader()
                .useLines { lines ->
                    lines.map { line ->
                        val (left, right) = line.split("   ").map { it.toInt() }
                        left to right
                    }.unzip()
                }
        }
    }
}