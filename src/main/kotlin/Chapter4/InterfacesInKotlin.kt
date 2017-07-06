package Chapter4

/**
 * Created by MurphySL on 2017/5/27.
 */
interface Clickable{
    fun click()
}

class Button : Clickable{
    override fun click() = println("Click")
}

fun main(args: Array<String>) {
    Button().click()
}