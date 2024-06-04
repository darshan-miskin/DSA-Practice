import kotlinx.coroutines.*
import utils.printCoroutineScopeInfo
import utils.printJobsHierarchy

fun main() {
//    println("start of main block")
//    runBlocking {
//        delay(1000)
//        println("inside run blocking")
//        CoroutineScope(Dispatchers.Default).launch {
//            delay(1000)
//            println("inside coroutine launch")
//        }
//    }
//
//
//    Thread.sleep(2000)
//    println("end of main block")


//    nestedWithContext()
//    nestedLaunchBuilders()
//    nestedCoroutineInOuterScope()


//    println("runBlocking entered")
//    runBlocking {
//        println("launch called")
//        val task1Def = task1()
//
//        val task2Def = task2()
//
//        println("addition started")
//        val val1 = task1Def.await()
//        val val2 = task2Def.await()
//        val sum = val1+val2
//
//        println("$val1 + $val2 = $sum")
//
//        println("launch finished")
//    }
//
//    println("runBlocking exited")


    runBlocking {
        launch {
            _task1()
            _task2()
        }
    }
}

suspend fun _task1() = withContext(Dispatchers.IO) {
    println("Task one started")
    delay(3000)
    println("Task one done")
    2
}

suspend fun _task2() = withContext(Dispatchers.IO) {
    println("Task two started")
    delay(2000)
    println("Task two done")
    2
}


//suspend fun task1() = run {
//    val scope = CoroutineScope(Dispatchers.IO)
//    scope.async {
//        println("Task one started")
//        delay(3000)
//        println("Task one done")
//        2
//    }
//}
//
//suspend fun task2() = run {
//    val scope = CoroutineScope(Dispatchers.IO)
//    scope.async {
//        println("Task two started")
//        delay(2000)
//        println("Task two done")
//        2
//    }
//}




/*
Write nested withContext blocks, explore the resulting Job's hierarchy, test cancellation
of the outer scope
 */
fun nestedWithContext() {
    runBlocking {
        val scopeJob = Job()
        val scope = CoroutineScope(scopeJob + CoroutineName("outer scope") + Dispatchers.IO)
        scope.launch(Dispatchers.Default) {
            withContext(Dispatchers.IO) {
                withContext(Dispatchers.IO) {
                    printJobsHierarchy(scope.coroutineContext.job)
                    delay(100)
                }
            }
        }
//        scope.cancel()
        scopeJob.join()
        println("test done")
    }
}

/*
Launch new coroutine inside another coroutine, explore the resulting Job's hierarchy, test cancellation
of the outer scope, explore structured concurrency
 */
fun nestedLaunchBuilders() {
    runBlocking {
        val scopeJob = Job()
        val scope = CoroutineScope(scopeJob + CoroutineName("outer scope") + Dispatchers.IO)

        scope.launch() {
            launch() {
                delay(100)
            }
            withContext(Dispatchers.Default){
                delay(100)
            }
            delay(100)
        }
        printJobsHierarchy(scopeJob)

        scopeJob.join()
        println("test done")
    }
}

/*
Launch new coroutine on "outer scope" inside another coroutine, explore the resulting Job's hierarchy,
test cancellation of the outer scope, explore structured concurrency
 */
fun nestedCoroutineInOuterScope() {
    runBlocking {
        val scopeJob = Job()
        val scope = CoroutineScope(scopeJob + CoroutineName("outer scope") + Dispatchers.IO)


        scopeJob.join()
        println("test done")
    }
}
