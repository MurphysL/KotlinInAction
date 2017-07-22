package Chapter2.k3

/**
 * Created by MurphySL on 2017/5/22.
 */
fun mix(c1 : Colors, c2 : Colors) =
        when(setOf(c1, c2)){
            setOf(Colors.RED, Colors.YELLOW) -> Colors.ORANGE
            setOf(Colors.BLUE, Colors.YELLOW) -> Colors.GREEN
            else -> throw Exception("Dirty color")
        }

fun main(args: Array<String>) {
    println(mix(Colors.RED, Colors.YELLOW))
}