package Chapter4

/**
 * Created by MurphySL on 2017/5/27.
 */
interface Clickable1{
    fun click()
    fun showOff() = println("clickable")
}

interface Focusable{
    fun setFocus(boolean: Boolean){
        println("I ${if(boolean) "got" else "lose"} focus")
    }

    fun showOff() = println("focusable")
}

class Button1 : Clickable1, Focusable{
    override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showOff() {
        super<Clickable1>.showOff()
        super<Focusable>.showOff()
    }

}

fun main(args: Array<String>) {
    val button  = Button1()
    button.setFocus(true)
    button.showOff()
    button.setFocus(false)
}