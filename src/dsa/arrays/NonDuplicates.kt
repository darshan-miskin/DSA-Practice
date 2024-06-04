package dsa.arrays

fun main(){
    val array= arrayOf(1,2,4,4,5,6,8,10,10,11,11)

    val nonDuplicates= getNonDuplicates(array)

    for(i in nonDuplicates.indices){
        println(nonDuplicates.get(i))
    }
}

/**
 * returns all the non duplicate elements
 * eg- array={1,2,2,3} then this function returns 1 & 3
 */
fun getNonDuplicates(array: Array<Int>):ArrayList<Int>{
    val nonDuplicates=ArrayList<Int>()
    val duplicates=HashSet<Int>()
    val set=HashSet<Int>()

    for(i in array.indices){
        if(set.contains(array[i])){
            duplicates.add(array[i])
        }
        else{
            set.add(array[i])
        }
    }

    for (i in array.indices){
        if(!duplicates.contains(array.get(i))){
            nonDuplicates.add(array.get(i))
        }
    }

    return nonDuplicates
}