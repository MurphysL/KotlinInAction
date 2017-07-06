package Chapter9.k3

/**
 * Created by MurphySL on 2017/5/24.
 */
fun <T> copy3( o : MutableList<T>, d : MutableList<in T>){ //型变注释 -> 逆变
    o.forEach{d.add(it)}
}

fun main(args: Array<String>) {
    val o = mutableListOf("pi", "zhen pi", "li shi zhen pi")
    val d = mutableListOf<Any>()

    copy2(o, d)
    d.forEach(::println)
}