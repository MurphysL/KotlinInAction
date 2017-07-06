package Coroutines

import kotlin.coroutines.experimental.*

/**
 * Created by MurphySL on 2017/6/30.
 */
class FilePath(val path : String ) : AbstractCoroutineContextElement(FilePath){
    companion object Key : CoroutineContext.Key<FilePath>
}

fun asyncCalcMd5(path : String , block : suspend () -> Unit){
    val continuation = object : Continuation<Unit>{
        override val context : CoroutineContext
            get() = FilePath(path)
        override fun resume(value : Unit){
            println("resume : $value")
        }

        override fun resumeWithException(exception: Throwable) {
            println(exception.toString())
        }
    }
    block.startCoroutine(continuation)
}

fun calacMd5(path : String) : String {
    println("calc md5 $path")
    Thread.sleep(1000)

    return System.currentTimeMillis().toString()
}

fun main(args: Array<String>) {
    println("before coroutine")

    asyncCalcMd5("test.zip") {
        println("in coroutine. before suspend")

        val result: String = suspendCoroutine {
            continuation ->
            println("in suspend block")
            continuation.resume(calacMd5(continuation.context[FilePath]!!.path))
        }
        println("in coroutine.After suspend .result = $result")
    }
    println("after coroutine")

}