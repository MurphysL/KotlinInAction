package Chapter6.k1

/**
 * Created by MurphySL on 2017/5/21.
 */
fun printAllCaps(s : String?) : String?{
    val allCaps = s?.toUpperCase()
    return allCaps
}

fun main(args: Array<String>) {
    println(printAllCaps(null))
    println(printAllCaps("kotlin"))
}