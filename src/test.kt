
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        val array = ArrayList<Int>()
        for((index, num) in nums.withIndex()){
            if(map.contains(num)){
                array.add(map.getValue(num))
                array.add(index)
            }
            map.put((target - num), index)
        }
        return array.toIntArray()
    }
}

fun main() {
    val s = Solution()
    var solution=s.twoSum(arrayOf(2,7,11,15).toIntArray(), 9)
    println(solution.toList().toString())
    solution = s.twoSum(arrayOf(3,2,4).toIntArray(), 6)
    println(solution.toList().toString())
}

fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hour" -> { value1 -> value1 * 60 * 60 }
    "minute" -> { value -> value * 60 }
    "second" -> { value -> value }
    else -> { value -> value }
}