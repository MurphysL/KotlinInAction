package Chapter2.k2

import java.util.*

/**
 * Created by MurphySL on 2017/5/20.
 */
class Rectangle(val height : Int , val width : Int){
    val isSquare : Boolean
    get() = height == width
}

fun createRandomSquare() : Rectangle {
    val random = Random()
    val rectangle = Rectangle(random.nextInt(), random.nextInt())
    return rectangle
}

fun main(args: Array<String>) {

    println(createRandomSquare().isSquare)
}