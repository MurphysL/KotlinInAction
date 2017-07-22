package Chapter2.k5

/**
 * return 只会跳出一个显式定义的函数，不会跳出 lambda 表达式，所以这里的 return 会直接跳出 main() 函数，结束进程。
 *
 * Created by MurphySL on 2017/7/22.
 */
fun main(args: Array<String>) {
    val a = intArrayOf(0, 1, 2, 3, 4, 5)
    a.forEach {
        if(it == 2) return
    }

    /*a.forEach {
        if(it == 2) return@forEach
    }*/

    println("break loop")
}