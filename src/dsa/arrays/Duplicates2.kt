//Leetcode 219: Contains Duplicate 2.
//Given an integer array nums & an integer k, return true if there are
//two distinct indices i & j in the array such that,
//nums[i] == nums[j] & abs(i-j) <= k
fun main(){
    val array= arrayOf(11,2,4,5,7,8,9,4,11)
    val k = 3
    println(containsDuplicates(array, k))
}

fun containsDuplicates(array: Array<Int>, k: Int): Boolean{
    val set = HashSet<Int>()
    array.forEachIndexed { i, it ->
        if(!set.add(it)) return true
        if(set.size > k) set.remove(array[i-k])
    }
    return false
}