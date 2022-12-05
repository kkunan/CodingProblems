package leetcode

import java.util.*
import kotlin.random.Random
import kotlin.test.assertEquals

fun main() {
    // beginning cases
    assertEquals(Solution().isValid("()"), true)
    assertEquals(Solution().isValid("()[]{}"), true)
    assertEquals(Solution().isValid("(]"), false)
    assertEquals(Solution().isValid("([]{})"), true)
    assertEquals(Solution().isValid("([)]"), false)

    // single string
    assertEquals(Solution().isValid("("), false)

    // all odd number length should return false
    repeat(100){
        val oddValue = (Random.nextInt(4999) * 2) + 1
        assertEquals(Solution().isValid(generateTestCases(oddValue)), false)
    }

    // single pair of correct value
    assertEquals(validate("()"), true)
    assertEquals(validate("[]"), true)
    assertEquals(validate("{}"), true)

    // two pairs, open close correctly
    assertEquals(validate("()[]"), true)
}

private fun validate(str: String): Boolean = Solution().isValid(str)

class Solution {
    fun isValid(s: String): Boolean {
        println(s)
        // odd length, false for sure
        if(s.length % 2 != 0){
            return false
        }

        val stack = Stack<String>()
        val correctPair = mapOf(
                "{" to "}",
                "(" to ")",
                "[" to "]"
        )
        s.forEach { char ->
            if(char == '{' || char == '[' || char == '('){
                stack.push(char.toString())
            } else {
                if(stack.isEmpty()){
                    return false
                }
                val top = stack.pop()
                if (correctPair[top] != char.toString()){
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}

private fun generateTestCases(length: Int): String {
    val chars = listOf("(",")","[","]","{","}")
    return (1..length).joinToString(separator = "") {
        chars[Random.nextInt(chars.size)]
    }
}