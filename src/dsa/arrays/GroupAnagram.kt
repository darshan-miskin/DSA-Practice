package dsa.arrays

//leetcode 49
fun main(){
    println(groupAnagrams(arrayListOf("rat","tar","bar","art","arb","raf")))
}

fun groupAnagrams(strArray: ArrayList<String>): ArrayList<ArrayList<String>>{
    if (strArray.isEmpty()) return arrayListOf()

    val baseKeyArray = Array(26){0}

    val map = HashMap<String, ArrayList<String>>()
    strArray.forEach { str ->
        val keyArray = baseKeyArray.copyOf()
        str.forEach { char ->
            keyArray[char - 'a']++
        }
        val key = keyArray.contentToString()
        if(!map.contains(key))
            map[key] = ArrayList()

        map[key]?.add(str)
    }

    return ArrayList(map.values)
}