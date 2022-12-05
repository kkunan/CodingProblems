package leetcode

import kotlin.test.assertEquals

fun main() {
//    assertEquals("fl", longestCommonPrefix(arrayOf("flower","flow","flight")))
//    assertEquals("", longestCommonPrefix(arrayOf("dog","racecar","car")))
    assertEquals("c", longestCommonPrefix(arrayOf("cir", "car")))
}

private fun longestCommonPrefix(strs: Array<String>): String {
    val shortestLength = strs.minBy { it.length }?.length ?: 0
    var output = ""
    (0 until shortestLength).forEach { index ->
        val charAtIndex = strs[0][index]
        strs.forEach second@{
            if (it[index] != charAtIndex) {
                return output
            }
        }
        output += charAtIndex
    }
    return output
}