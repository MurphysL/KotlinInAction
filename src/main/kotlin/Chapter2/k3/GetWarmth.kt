package Chapter2.k3

/**
 * Created by MurphySL on 2017/5/22.
 */
enum class Color2{
    RED, GREEN, BLUE, ORANGE, YELLOW
}

fun getWarmth(color : Color2) =
        when(color){
            Color2.GREEN -> "neutral"
            Color2.BLUE -> "cold"
            Color2.ORANGE, Color2.RED -> "warm"
            else -> "else"
        }

fun main(args: Array<String>) {
    println(getWarmth(Color2.ORANGE))
}