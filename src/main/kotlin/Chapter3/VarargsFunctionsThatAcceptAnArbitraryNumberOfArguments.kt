package Chapter3

/**
 * Created by MurphySL on 2017/5/20.
 */
fun main(args: Array<String>) {
    val oldlist = arrayOf("kotlin", "hi", "java")
    val list = listOf("hello", *oldlist)
    println(list)
}