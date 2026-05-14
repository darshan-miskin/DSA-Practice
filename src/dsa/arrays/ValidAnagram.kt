package dsa.arrays


//Leetcode 242: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
fun main(){
    println(areAnagram("Rat", "Tar"))
}

fun areAnagram(str1: String, str2: String): Boolean{
    if (str1.trim().length != str2.trim().length) return false

    val charArray = Array(26){0}

    (0..str1.lastIndex).forEach {
        charArray[str1[it].lowercaseChar() - 'a']++
        charArray[str2[it].lowercaseChar() - 'a']--
    }

    charArray.forEach {
        if(it != 0 ) return false
    }
    return true
}