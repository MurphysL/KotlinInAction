package Chapter6.k1

/**
 * Created by MurphySL on 2017/5/23.
 */
fun ignoreNulls(s : String?){
    val sNotNull : String = s !!
    println(sNotNull.length)
}

fun main(args: Array<String>) {
    ignoreNulls(null)
}