package dsa.search

fun main() {
    val array= arrayOf(1,10,15,16,50,55,62,71,72,76,79,82,84)
//                     0  1  2  3  4  5  6  7  8  9 10 11 12

    println("Enter a number to dsa.search")

    var num:Int= readLine()!!.toInt()

    binarySearch(array,num)
}
fun binarySearch(array:Array<Int>, num:Int){

    var left=0; var right=array.lastIndex; var mid=0;

    var isFound=false

    while(right>=left){
        mid=(left+right)/2
        if(array[mid]==num){
            isFound=true
            print("$num found at index $mid")
            break
        }
        else if(array[mid]<num){
            left=mid+1;
        }
        else if (array[mid]>num){
            right=mid-1
        }
    }
    if(!isFound)
        println("Could not find $num")
}
