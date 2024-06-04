package dsa.arrays

import java.util.*
import java.util.HashMap
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*


// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>) {
    val magazineMap: MutableMap<String, Int> = HashMap(magazine.size)

    for (w in magazine) {
        magazineMap.merge(w, 1) { a: Int?, b: Int? -> Integer.sum(a!!, b!!) }
    }

    for(i in note){
        if(magazineMap.containsKey(i) && magazineMap.getValue(i)>0){
            magazineMap.replace(i,magazineMap.getValue(i)-1)
        }
        else{
            println("No")
            return
        }
    }
    println("Yes")
}

fun test(s: String){
    for(c in s.toList()){
        when(c){
            'I' -> {}
        }
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}