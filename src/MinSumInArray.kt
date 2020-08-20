fun main(){
    val array= arrayOf(5,20,5,1,25,74,10,30,3,8,7)

    minSum(array)
}

/**
 * prints out the two minimum values in an array along with its sum.
 * Time complexity -> O(n)
 */
fun minSum(array:Array<Int>){
    if(array.size>1) {
        var indexA=0
        var indexB=0
        var minA = array[indexA]
        var minB=array[indexB]
        val min: Int

        for (i in array.indices){
           if (array[i]<minA){
               minA=array[i]
               indexA=i
           }
            if (i!=indexA && array[i]<minB){
                minB=array[i]
                indexB=i
            }
        }
        min=minA+minB
        println("minimum sum in array is $min with elements ${array[indexA]} and ${array[indexB]} at index $indexA & $indexB")
    }
    else{
        println("Cannot find sum with just one element")
    }
}