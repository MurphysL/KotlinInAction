package Chapter2.k4

/**
 * Created by MurphySL on 2017/7/22.
 */
fun recognize (c : Char) : String = when{
    c in '0'..'9' -> "It's a digit!"
    c in 'a'..'z' || c in 'A'..'Z' -> "It's a letter!"
    else -> "I dont't know..."
}

fun main(args: Array<String>) {
    println(recognize('0'))

    val arrayInt = intArrayOf(1, 1, 1, 1, 1)

    for (item in arrayInt) {

        println("arrayInt[${arrayInt.indexOf(item)}] is $item")

    }
}