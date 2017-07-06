package Chapter3

/**
 * Created by MurphySL on 2017/5/20.
 */

val set = hashSetOf(1, 2, 3)
val list = arrayListOf(1, 2, 3)
val map = hashMapOf(
        1 to "one",
        2 to "two",
        3 to "three")

fun main(args: Array<String>) {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("pi", "zhen pi", "li shi zhen pi")
    println(strings.last())
    val values = setOf(1, 2, 3)
    println(values.max())
}