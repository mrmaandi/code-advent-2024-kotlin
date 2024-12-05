package day03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun part1() {
        assertEquals(4, Day03.findMultiplications("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"))
    }

    @Test
    fun part2() {
        assertEquals(
            "xmul(2,4)&mul[3,7]!^?mul(8,5))",
            Day03.desanitizeInput("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))don't()_mul(5,5)+mul(32,64]")
        )
    }
}