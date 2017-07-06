package Chapter6.k2

/**
 * Created by MurphySL on 2017/5/23.
 */
fun showProgress(progress : Int){
    val percent = progress.coerceIn(0, 100)
    println("$percent%")
}

fun main(args: Array<String>) {
    val value = 1997
    showProgress(value)
}