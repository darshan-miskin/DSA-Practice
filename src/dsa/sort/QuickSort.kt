package dsa.sort

import java.util.*

fun main(){
    var array= arrayOf(6,45,8,6,480,45,48,65,34,16,76,49,83,27,0,85)

    var left=0
    var right=array.lastIndex

    var startTime=Calendar.getInstance().timeInMillis

    quickSort(array, left, right)

    var endTime=Calendar.getInstance().timeInMillis
    var timeTaken:Double=(endTime.toDouble()-startTime.toDouble())/1000

    println("It took $timeTaken seconds to dsa.sort")

    for (value in array)
        print("$value ")
}

fun quickSort(array:Array<Int>, left:Int, right:Int){
    if(left<right){
        val partition= partition(array,left,right)
        quickSort(array,left,partition-1)
        quickSort(array,partition+1,right)
    }
}

fun partition(array:Array<Int>, left:Int, right:Int):Int{
    var j=left
    val pivot=array[right]

    for(i in left..right){
        if(array[i]<pivot){
            swap(array,i,j)
            j++
        }
    }
    swap(array,j,right)
    return j
}

fun swap(array: Array<Int>, leftIndex:Int, rightIndex:Int){
    val temp=array[leftIndex]
    array[leftIndex]=array[rightIndex]
    array[rightIndex]=temp
}