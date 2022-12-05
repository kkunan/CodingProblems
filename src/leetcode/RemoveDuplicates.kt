package leetcode

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.test.assertEquals

fun main(){
    repeat(100){
        test()
    }
}

private fun test(){
    // no duplicates
    val multiplier = Random.nextInt(5) + 1
    val noDup = (1..Random.nextInt(20)).map {
        it * multiplier
    }
    val array = noDup.toIntArray()
    println("original: $noDup")
    val noDupResult = removeDuplicates(array)
//    println("result: $noDup")
    assertEquals(noDup.toIntArray().size, noDupResult)
//
////
//    // empty array
//    assertEquals(0, removeDuplicates(intArrayOf()))
////
//    // from -100
    val startFromMin = intArrayOf(-100, -100, 0, 20)
//    println("original: ${startFromMin.joinToString()}")
    val startFromMinResult = removeDuplicates(startFromMin)
//    println("result: ${startFromMin.joinToString()}")
    assertEquals(startFromMinResult, 3)
    assertEquals(startFromMin.distinct().joinToString(), intArrayOf(-100, 0, 20).joinToString())
////
////    // to 100
    val endWithMax = intArrayOf(-2, 0, 24, 100)
//    println("original: ${endWithMax.joinToString()}")
    val endWithMaxResult = removeDuplicates(endWithMax)
//    println("result: ${endWithMax.joinToString()}")
    assertEquals(endWithMaxResult, 4)
    assertEquals(endWithMax.joinToString(), intArrayOf(-2, 0, 24, 100).joinToString())
////
////    // all the same
    val randomNum = Random.nextInt(100)
    val allTheSame = (1..30000).map { randomNum }.toIntArray()
//    println("original: ${allTheSame.joinToString()}")
    val allTheSameResult = removeDuplicates(allTheSame)
//    println("result: ${allTheSame.joinToString()}")
    assertEquals(allTheSameResult, 1)
//
//    // some dups
    val range = (1..Random.nextInt(30)).map {
        Random.nextInt(100) * if(Random.nextBoolean()) 1 else -1
    }.sorted().toIntArray()
    val distinct = range.sorted().distinct().toIntArray()
    println("original: ${range.joinToString()}")
    assertEquals(removeDuplicates(range), distinct.size)
//    println("result: ${range.joinToString()}")
//    println("distinct: ${distinct.joinToString()}")
    assertEquals(range.slice((0 until distinct.size)).joinToString(), distinct.joinToString())
}

private fun removeDuplicates(nums: IntArray): Int {
    val size = nums.size
    // empty or single element
    if(size < 2){
        return size
    }

    // other cases
    var currentIndex = 1
    var currentValue = nums[0]
    nums.forEachIndexed { index, value ->
        if(currentValue != value){
//            println("not equal at index $index $currentValue, current $currentIndex $value")
            nums[currentIndex] = value
            currentValue = value
            currentIndex++
            if(currentValue == nums[size-1]){
                return currentIndex
            }
        }
    }
    return currentIndex
}