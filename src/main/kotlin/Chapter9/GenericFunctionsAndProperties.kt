package Chapter9

/**
 * Created by MurphySL on 2017/5/23.
 */
fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..13))
}