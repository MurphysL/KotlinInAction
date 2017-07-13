package Chapter2.k1

/**
 * 在 Kotlin 中， if 是一个表达式，即它会返回一个值，因此无需三元运算符
 *
 * Created by MurphySL on 2017/7/12.
 */
fun max(a : Int , b : Int) : Int{
    return if(a > b) a else b
}

fun main(args: Array<String>) {
    println(max(10, 20))
}