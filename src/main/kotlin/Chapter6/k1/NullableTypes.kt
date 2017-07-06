package Chapter6.k1

/**
 * Created by MurphySL on 2017/5/21.
 */
fun strLenSaft(s : String?) : Int =
        s?.length ?: 0

fun main(args: Array<String>) {
    val s : String? = null

    println(strLenSaft(s))
    println(strLenSaft("hello kotlin"))
}