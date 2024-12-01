package day1

import kotlin.math.abs

class Day1 {
    companion object {
        fun part1(): Int {
            val (list1, list2) = getLocations()
            return list1.sorted().zip(list2.sorted()).sumOf { (a, b) -> abs(a - b) } // 1189304
        }

        fun part2(): Int {
            val (list1, list2) = getLocations()
            val occurrences = list2.groupingBy { it }.eachCount().toMutableMap()
            return list1.sumOf { it * occurrences.getOrDefault(it, 0) }
        }

        private fun getLocations(): LocationIds {
            val list1 = mutableListOf<Int>()
            val list2 = mutableListOf<Int>()

            this::class.java.getResourceAsStream("input.txt")!!
                .bufferedReader()
                .useLines { lines ->
                    lines.forEach { line ->
                        val split = line.split("   ")
                        list1.add(split[0].toInt())
                        list2.add(split[1].toInt())
                    }
                }
            return LocationIds(list1, list2) // 24349736
        }
    }
}