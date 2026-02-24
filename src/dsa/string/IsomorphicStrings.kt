package dsa.string

/*
*
* Two strings are considered isomorphic if the characters in the first string can be replaced to obtain the second string, with the following constraints:
*
* One-to-one mapping: Each character in string s maps to a unique character in string t
* Consistency: All occurrences of a character must be replaced with the same character, maintaining order.
* Bijective: No two characters from s can map to the same character in t
*
*/

fun main() {
    println(isIsomorphic("paper", "title"))
    println(isIsomorphic("abc", "xxz"))
    println(isIsomorphic("egg", "add"))
    println(isIsomorphic("label", "cable"))
    println(isIsomorphic("aab", "xyz"))
    println(isIsomorphic("p12", "d33"))
    println(isIsomorphic("ACAB", "XCXY"))
    println(isIsomorphic("a", "aab"))
}

fun isIsomorphic(str1: String, str2: String) : Boolean {
    if(str1.length != str2.length) return false

    val map = HashMap<Char, Char>()

    str2.forEachIndexed { index, ch ->
        if(map.containsKey(ch) || map.containsValue(str1[index])) return@forEachIndexed

        map[ch] = str1[index]
    }

    var temp = str2

    map.forEach { (key, value) ->
        temp = temp.replace(key, value)
    }

    return temp == str1
}