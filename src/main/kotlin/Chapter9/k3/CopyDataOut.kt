package Chapter9.k3

/**
 * Created by MurphySL on 2017/5/23.
 */
fun <T> copy2( o : MutableList<out T>, d : MutableList<T>){ //型变注释
    o.forEach{d.add(it)}
}

fun main(args: Array<String>) {
    val o = mutableListOf("pi", "zhen pi", "li shi zhen pi")
    val d = mutableListOf<Any>()

    copy2(o, d)
    d.forEach(::println)
}