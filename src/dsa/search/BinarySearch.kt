package dsa.search

fun main() {
    val array = arrayOf(1, 10, 15, 16, 50, 55, 62, 71, 72, 76, 79, 82, 84)
//   indexes ->         0   1   2   3   4   5   6   7   8   9  10  11  12

    println(array.toList())
    println("Enter a number to search in above array")

    val num= readln().toInt()

    if(!binarySearch(array,num)) println("Could not find $num")
}

fun binarySearch(array:Array<Int>, search:Int): Boolean {
    var start = 0
    var end = array.lastIndex

    while (start<=end){
        val mid= (start+end)/2

        if(array[mid]==search) {
            println("element found at index $mid")
            return true
        }
        if(array[mid]>search) end = mid-1
        else start = mid+1
    }
    return false
}
