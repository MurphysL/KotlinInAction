package Chapter3

/**
 * Created by MurphySL on 2017/5/20.
 */
fun main(args: Array<String>) {
    val origin : String = "123.456-789-1011"
    println(origin.split("\\.|-".toRegex()))
    println(origin.split(".","-"))
}