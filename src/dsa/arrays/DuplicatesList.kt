package dsa.arrays

fun main(){
    val array= arrayOf(11,2,2,4,5,5,7,8,9,4,11)

    val duplicates= showDuplicates(array)
    
    for (i in duplicates.indices){
        println(duplicates.get(i))
    }
}

/**
 * Returns all the duplicate elements in an array
 */
fun showDuplicates(array: Array<Int>):ArrayList<Int>{
    val set=HashSet<Int>()
    val duplicates=ArrayList<Int>()

    for (i in array.indices){
        if (!set.add(array[i])){
            duplicates.add(array[i])
        }
    }
    return duplicates
}