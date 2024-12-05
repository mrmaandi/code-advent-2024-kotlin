package day03

class Day03 {
    companion object {
        fun part1(): Long {
            return this::class.java.getResourceAsStream("input.txt")!!
                .bufferedReader()
                .useLines { lines -> lines.sumOf { findMultiplications(it) } }
        }

        fun findMultiplications(input: String): Long {
            return parseMultiplications(input)
        }

        fun part2(): Long {
            return this::class.java.getResourceAsStream("input.txt")!!
                .bufferedReader()
                .use { reader ->
                    val input = reader.readText()
                    findMultiplicationsAlternate(input)
                }
        }

        private fun findMultiplicationsAlternate(input: String): Long {
            return parseMultiplications(desanitizeInput(input))
        }

        fun desanitizeInput(input: String): String {
            val singleLineInput = input.replace("\n", "")
            val ignoreBetweenRegex = """don't\(\).*?do\(\)""".toRegex()
            val newInput = ignoreBetweenRegex.replace(singleLineInput, "")
            val ignoreEndRegex = """don't.*""".toRegex()
            return ignoreEndRegex.replace(newInput, "")
        }

        private fun parseMultiplications(input: String): Long {
            val regex = """mul\((\d+),(\d+)\)""".toRegex()
            return regex.findAll(input)
                .map { match ->
                    val (a, b) = match.destructured
                    a.toLong() * b.toLong()
                }
                .onEach { println(it) }
                .sum()
        }
    }
}