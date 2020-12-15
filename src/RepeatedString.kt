import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/**
 * Solution ot hackerrank problem: https://www.hackerrank.com/challenges/repeated-string/problem
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
