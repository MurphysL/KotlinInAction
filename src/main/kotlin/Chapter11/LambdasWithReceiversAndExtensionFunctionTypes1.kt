package Chapter11

/**
 * Created by MurphySL on 2017/5/20.
 */
fun stringBuilder(stringAction : StringBuilder.()->Unit) : StringBuilder{
    val builder = StringBuilder()
    builder.stringAction()
    return builder
}

fun main(args: Array<String>) {
    val s = stringBuilder {
        append("hi,")
        append("java")
    }
    println(s)
}