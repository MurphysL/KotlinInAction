package Chapter9.k3

/**
 * 只能读取 -> 生产者
 * 只能写入 -> 消费者
 * Created by MurphySL on 2017/5/23.
 */
fun <R : T ,T> copy( o : MutableList<R>, d : MutableList<T>){
    o.forEach{d.add(it)}
}

fun main(args: Array<String>) {
    val o = mutableListOf("pi", "zhen pi", "li shi zhen pi")
    val d = mutableListOf<Any>()

    copy(o, d)
    d.forEach(::println)
}