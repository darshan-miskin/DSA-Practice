package dsa.arrays

import kotlin.math.max

fun main(){
//    val arr = arrayOf(2, 3, -8, 7, -1, 2, 3)
//    val arr = arrayOf(-2, -4)
//    val arr = arrayOf(5, 4, 1, 7, 8)
//    val arr = arrayOf(-2, -4, 10, -3)
    val arr = arrayOf(3, -4, 1, 1, 1, 1, 3)
    println(maxSubarraySum(arr))
}

/**
 * returns the maximum sum in an unsorted array.
 * Time complexity -> O(n)
 */
fun maxSubarraySum(array: Array<Int>): Int {
    var maxSum = array[0]
    var maxArray = array[0]

    for (i in 1..array.lastIndex){
        maxArray = max(maxArray+array[i], array[i])

        maxSum = max(maxSum, maxArray)
    }
    return maxSum
}