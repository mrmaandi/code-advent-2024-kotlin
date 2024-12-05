package day02

import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {

    @Test
    fun test() {
        assertEquals(true, Day02.isSafeReportLenient("10 4 7 9 11 13"))

        assertEquals(true, Day02.isSafeReportLenient("7 6 4 2 1"))
        assertEquals(false, Day02.isSafeReportLenient("1 2 7 8 9"))
        assertEquals(false, Day02.isSafeReportLenient("9 7 6 2 1"))
        assertEquals(true, Day02.isSafeReportLenient("1 3 2 4 5"))
        assertEquals(true, Day02.isSafeReportLenient("8 6 4 4 1"))
        assertEquals(true, Day02.isSafeReportLenient("1 3 6 7 9"))
    }

}