package Chapter10

/**
 * Created by MurphySL on 2017/5/22.
 */
class Person(val name : String, val age : Int)

fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.members.forEach(::println)
}