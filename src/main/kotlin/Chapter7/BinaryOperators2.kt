package Chapter7

/**
 * Created by MurphySL on 2017/5/25.
 */

operator fun Point.times(scale : Double) : Point{
    return Point(this.x*scale.toInt(), this.y*scale.toInt())
}

fun main(args: Array<String>) {
    val p1 : Point = Point(10, 20)
    println(p1*1.5)
}