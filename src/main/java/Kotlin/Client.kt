package Kotlin

/**
 * Client
 *
 * Created by MurphySL on 2017/7/2.
 */
fun main(args: Array<String>) {
    val product : Product = Product(param1 = "param1")
    println(product.toString())

    val product2 : Product = Product(param1 = "hello", param3 = "world")
    println(product2.toString())
}