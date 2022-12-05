package leetcode

import kotlin.random.Random
import kotlin.test.assertEquals

fun main() {
    // beginning cases
    test("1,2,4", "1,3,4", "1,1,2,3,4,4")
    test("", "", "")
    test("0", "", "0")

    // first empty, return second
    repeat(30) {
        val value = Random.nextInt(100)
        test("", "$value", "$value")
    }

    // second empty, return first
    test("", "1,23,64", "1,23,64")

    // all first less than second, return first then second
    test("-100,-50,0", "1,2,100", "-100,-50,0,1,2,100")

    // all second less than first, return second then first
    test("1,2,100", "-100,-50,0", "-100,-50,0,1,2,100")

    // all same values, return them concat
    test("1,1,1", "1", "1,1,1,1")

    // complicated cases
    repeat(100) {
        val firstSize = Random.nextInt(50)
        val secondSize = Random.nextInt(50)

        val input1 = (1..firstSize).map {
            Random.nextInt(100)
        }.sorted()

        val input2 = (1..secondSize).map {
            Random.nextInt(100)
        }.sorted()

        val sorted = (input1 + input2).sorted()
        println("input1: $input1")
        println("input2: $input2")
        println("sorted: $sorted")
        test(input1.joinToString(separator = ",") { it.toString() },
            input2.joinToString(separator = ",") { it.toString() },
            sorted.joinToString(separator = ",") { it.toString() }
        )
    }

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    var current1 = list1
    var current2 = list2
    var result: ListNode? = null
    var lastResult = result
    while (current1 != null && current2 != null) {
        if (current1.value < current2.value) {
            val newNode = ListNode(current1.value)
            if (result == null) result = newNode
            else lastResult?.next = newNode

            current1 = current1.next
            lastResult = newNode
        } else {
            val newNode = ListNode(current2.value)
            if (result == null) result = newNode
            else lastResult?.next = newNode

            current2 = current2.next
            lastResult = newNode
        }
    }

    while (current1 != null) {
        lastResult?.next = ListNode(current1.value)
        current1 = current1.next
        lastResult = lastResult?.next
    }

    while (current2 != null) {
        lastResult?.next = ListNode(current2.value)
        current2 = current2.next
        lastResult = lastResult?.next
    }

    return result
}

class ListNode(var value: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return value.toString() + (next?.toString() ?: "")
    }
}

private fun test(input1: String, input2: String, expected: String) {
    assertEquals(
        formatOutput(expected),
        mergeTwoLists(
            createListNodeFromInput(input1),
            createListNodeFromInput(input2)
        ).toString()
    )
}

private fun formatOutput(str: String) = if (str.isEmpty()) "null" else str.replace(",", "")
private fun formatInput(str: String) = if (str.isEmpty()) emptyList() else str.split(",").map { it.toInt() }

private fun createListNodeFromInput(str: String): ListNode? {
    val value = formatInput(str)
    if (value.isEmpty())
        return null
    val start = ListNode(value[0])
    var current = start
    (1 until value.size).forEach {
        val next = ListNode(value[it])
        current.next = next
        current = next
    }
    return start
}