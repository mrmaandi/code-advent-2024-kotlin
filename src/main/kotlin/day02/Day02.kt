package day02

import kotlin.math.abs

class Day02 {
    companion object {
        fun part1(): Int {
            return this::class.java.getResourceAsStream("input.txt")!!
                .bufferedReader()
                .useLines { it ->
                    it.count { isSafeReport(it) }
                }
        }

        private fun isSafeReport(line: String): Boolean {
            val pairs = line
                .split(" ")
                .map { it.toInt() }
                .windowed(2, 1)
                .map { (a,b) -> a to b }
            val firstPair = pairs.first()
            val isAscending = firstPair.first < firstPair.second
            return pairs.all { isValidPair(it, isAscending) }
        }

        fun part2(): Int {
            return this::class.java.getResourceAsStream("input.txt")!!
                .bufferedReader()
                .useLines { lines ->
                    lines.count { line -> isSafeReportLenient(line) }
                }
        }

        fun isSafeReportLenient(line: String): Boolean {
            val listOfLevels = line
                .split(" ")
                .map { it.toInt() }
                .toList()

            // remove one element and see if valid
            for (i in listOfLevels.indices) {
                val listOfLevelsModified = listOfLevels.toMutableList()
                listOfLevelsModified.removeAt(i)
                if (isSafeReport(listOfLevelsModified.joinToString(" "))) return true
            }

            return false
        }

        private fun isValidPair(
            pair: Pair<Int, Int>,
            isAscending: Boolean
        ): Boolean {
            val (first, second) = pair
            val difference = abs(first - second)
            if (difference == 0 || difference > 3) {
                return false
            }
            if (isAscending && first > second || !isAscending && first < second) {
                return false
            }
            return true
        }
    }
}