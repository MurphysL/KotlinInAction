package Chapter7


/**
 * Created by MurphySL on 2017/5/25.
 */
class Point(val x : Int, val y : Int){
    operator fun plus(p : Point) : Point{
        return Point(x + p.x, y + p.y)
    }

    override fun toString(): String {
        return "Point[$x, $y]"
    }
}

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 20)
    println(p1 + p2)
}