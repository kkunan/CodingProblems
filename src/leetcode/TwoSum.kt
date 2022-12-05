package leetcode

import java.lang.Integer.max
import kotlin.math.absoluteValue
import kotlin.math.min
import kotlin.random.Random
import kotlin.test.assertEquals

fun main() {
    testCases.forEach {
        println(it)
        assertEquals(it.output.toList().toString(),
                twoSum(it.input, it.target).toList().toString())
    }
}

private val testCases = listOf(
        TestCase(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
        TestCase(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
        TestCase(intArrayOf(3, 3), 6, intArrayOf(0, 1))
) + listOf(
        generateCase(Random.nextInt(100).absoluteValue),
        generateCase(Random.nextInt(100).absoluteValue),
        generateCase(Random.nextInt(100).absoluteValue),
        generateCase(Random.nextInt(100).absoluteValue),
        generateCase(Random.nextInt(100).absoluteValue),
        generateCase(Random.nextInt(10).absoluteValue)
)


private fun generateCase(length: Int): TestCase {
    val input = mutableListOf<Int>()
    repeat(length) {
        input.add(Random.nextInt())
    }
    val randomIndex = Random.nextInt(length)
    val randomIndex2 = Random.nextInt(length).let {
        var current = it
        while (current == randomIndex) {
            current = Random.nextInt(length)
        }
        current
    }

    val target = input[randomIndex] + input[randomIndex2]
    val output = intArrayOf(min(randomIndex, randomIndex2),
            max(randomIndex, randomIndex2))
    return TestCase(input.toIntArray(), target, output)
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    var output: IntArray = intArrayOf(0, 0)
    kotlin.run breaking@{
        nums.forEachIndexed { index, current ->
            val another = target - current
            val indexOfAnother = nums.indexOfLast { it == another }
//                println("index: $index, current: $current")
//                println("indexOfAnother: $indexOfAnother, another: $another")
            if (indexOfAnother != -1 && indexOfAnother != index) {
                output = intArrayOf(index, indexOfAnother)
//                    println("change output: ${output.toList()}")
                return@breaking
            }
        }
    }

    return output
}

private data class TestCase(
        val input: IntArray,
        val target: Int,
        val output: IntArray
)