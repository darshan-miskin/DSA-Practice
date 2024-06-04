package dsa.string

import java.util.*
import kotlin.io.*
import kotlin.text.*

/**
 * Solution ot hackerrank problem: https://www.hackerrank.com/challenges/repeated-dsa.string/problem
 * Time Complexity O(n)
 */
fun repeatedString(s: String, n: Long): Long {

    var noOfAs=0
    var extra=0
    val remainder=n%s.length
    val multi=(n-remainder)/s.length

    for(i in s.indices){
        if(s.get(i)=='a'){
            if(i<remainder){
                extra++
            }
            noOfAs++
        }
    }

    return (noOfAs*multi)+extra
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
