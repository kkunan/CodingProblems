package leetcode

import kotlin.random.Random
import kotlin.test.assertEquals

// https://leetcode.com/problems/roman-to-integer/

private val testCases = mapOf(
        // sample
        "III" to 3,
        "LVIII" to 58,
        "MCMXCIV" to 1994,

        // single char
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000,

        // normal max to min should sum
        "VI" to 6,
        "XXV" to 25,
        "MDC" to (1000 + 500 + 100),
        "CCC" to 300,

        // smaller to deduct
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900,

        "CCLII" to 252,
        "CLXXVIII" to 178,
        "DCCI" to 701,
        "DCCC" to 800,
        "CMLXXIX" to 979,
        "CCXXVIII" to 228,
        "DXCIX" to 599,
        "CX" to 110,
        "CMLXXXI" to 981,
        "CCCXXI" to 321,

        // null case
        "" to 0
)

fun randomCase(): String = "IVXLCDM".split("").random().let {
    if (Random.nextBoolean())
        it + randomCase() else it
}

fun main() {
    testCases.forEach { (s, i) ->
        println(s)
        assertEquals(i, romanToInt(s))
    }

//    repeat(10) {
//        val random = randomCase()
//        println("$random = ${romanToInt(random)}")
//
//    }
}

val charValues = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
)

fun romanToInt(s: String): Int {
    var result = 0
    var previousValue = 1000
    s.toCharArray().forEach { current ->
        val currentValue = charValues[current.toString()] ?: 0
        result += if (currentValue > previousValue) {
            (currentValue - (previousValue * 2))
        } else {
            currentValue
        }
        previousValue = currentValue
    }
    return result
}