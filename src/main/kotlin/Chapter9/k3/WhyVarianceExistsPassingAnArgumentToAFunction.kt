package Chapter9.k3

/**
 * Created by MurphySL on 2017/5/23.
 */
fun printContents(list : List<Any>){
    println(list.joinToString(separator = ",", prefix = "[", postfix = "]"))
}

fun main(args: Array<String>) {
    printContents(listOf(9, 5, 7))
    printContents(listOf('1', '2', '5'))
}