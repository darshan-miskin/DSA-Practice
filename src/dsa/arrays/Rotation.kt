package dsa.arrays

import java.util.*

fun main(){
//    {2,3,4,5,6}
    println("Enter size of array")
    val scn=Scanner(System.`in`)
    val size=scn.nextInt()
    println("Enter array elements")
    val array=Array(size) { 0 }
    for (i in 0 until size)
        array[i]=scn.nextInt()

    println("Enter rotation count")
    val rotateBy=scn.nextInt()

    val finalArray= rotate(array, rotateBy)

    println("After left rotation by $rotateBy")
    print(array.toList())

}

//fun rotate(array: Array<Int>, rotateBy:Int):Array<Int>{
//    for (j in 0 until rotateBy) {
//        val temp=array[0]
//        for (i in 1 until array.size)
//            array[i - 1] = array[i]
//        array[array.size - 1] = temp
//    }
//
//    return array
//}

fun rotate(array: Array<Int>, rotate:Int):Array<Int>{
    val rotateBy = rotate%array.size
    val tempArray = ArrayList<Int>()
    var tempIndex = 0

    for (i in 0 until rotateBy)
        tempArray.add(array[i])

    for (i in rotateBy..array.lastIndex) {
        array[i - rotateBy] = array[i]

        if (i>=array.size - rotateBy){
            array[i] = tempArray[tempIndex]
            tempIndex++
        }
    }

    return array
}