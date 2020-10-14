import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.math.sign
import kotlin.ranges.*
import kotlin.text.*

/**
 * Solution of HackerRank problem https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
fun minimumBribes(array: Array<Int>) {

    var swaps=0;

    for (i in array.size downTo 1){
        val offBy=find(array,i)
        if(abs(offBy)>=3){
            swaps=0
            println("Too chaotic")
            break
        }
        else if(abs(offBy)>0) {
            var position = (i-1) + offBy
            for(j in 1..abs(offBy)){
                val one=(1 * sign(offBy.toDouble())).toInt()

                val temp=array[position]
                array[position]=array[position-one]
                array[position-one]=temp

                swaps++
                position -= one
            }
        }
    }

    if (swaps>0)
        println(swaps)
}

fun find(array: Array<Int>, toFind:Int):Int{
    for(i in 0..2){
        val index=toFind-1
        if(array[index]!=toFind){
            if(index-i>=0){
                if(array[index-i]==toFind){
                    return -i
                }
            }
            if(index+i<=array.lastIndex){
                if(array[index+i]==toFind){
                    return i
                }
            }
        }
        else
            return 0
    }
    return 10
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    val list=ArrayList<Array<Int>>()
    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        list.add(q)
    }

    for (i in list.indices){
        minimumBribes(list[i])
    }
}
