package Chapter9

/**
 * Created by MurphySL on 2017/5/23.
 */
fun <T>trailingPeriod(seq : T) : T where T : CharSequence ,
        T : Appendable{
    if(seq.endsWith("."))
        seq.append(".")

    return seq
}

fun main(args: Array<String>) {
    val helloworld = StringBuilder("Hello World")
    trailingPeriod(helloworld)

    println(helloworld)
}