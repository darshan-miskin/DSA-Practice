package coroutine

import kotlinx.coroutines.*
import java.util.Calendar

fun main(){
    runBlocking {
        val start = Calendar.getInstance().timeInMillis
        val task1Result = async {
            task1(start)
        }
        val task2Result = async {
            task2(start)
        }

        println("${task1Result.await()} \t ${task2Result.await()}")

        println("run Blocking end")
    }
}

suspend fun task1(start: Long) = withContext(Dispatchers.IO){
    delay(3000)
    val end = Calendar.getInstance().timeInMillis
    println("task1 done in: ${(end-start)/1000} seconds")
    3000
}

suspend fun task2(start: Long) = withContext(Dispatchers.IO){
    delay(4000)
    val end = Calendar.getInstance().timeInMillis
    println("task2 done in: ${(end-start)/1000} seconds")
    4000
}