package dsa.arrays

/**
 * Takes in two params. The function checks if two numbers from [nums] can be added
 * to get the [target]
 * @param nums Integer array
 * @param target sum value
 *
 * @return solution array containing indexes, returns an empty array if no solution.
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    val array = ArrayList<Int>()
    for((index, num) in nums.withIndex()){
        if(map.contains(num)){
            array.add(map.getValue(num))
            array.add(index)
        }
        map[(target - num)] = index
    }
    return array.toIntArray()
}

fun main() {
    var solution=twoSum(arrayOf(3,7,11,15).toIntArray(), 9)
    println(solution.toList().toString())

    solution = twoSum(arrayOf(3,2,4).toIntArray(), 6)
    println(solution.toList().toString())
}