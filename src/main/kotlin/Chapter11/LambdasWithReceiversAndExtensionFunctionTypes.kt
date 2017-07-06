package Chapter11

/**
 * Created by MurphySL on 2017/5/20.
 */
fun buildString (buildAction : (StringBuilder) -> Unit) : StringBuilder{
    val builder = StringBuilder()
    buildAction(builder)
    return builder
}

fun main(args: Array<String>) {
    val s = buildString {
        it.append("hello,")
        it.append("kotlin")
    }
    println(s)
}