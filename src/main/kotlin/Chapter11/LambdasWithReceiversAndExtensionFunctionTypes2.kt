package Chapter11

/**
 * Created by MurphySL on 2017/5/20.
 */
val appendExc1 : StringBuilder.()->Unit = {
    this.append("!")
}

fun stringBuild(buildAction : StringBuilder.()->Unit) : StringBuilder{
    val builder = StringBuilder()
    builder.buildAction()
    return builder
}

fun main(args: Array<String>) {
    val builder = StringBuilder()
    builder.appendExc1()
    println(builder)

    println(stringBuild(appendExc1))
}