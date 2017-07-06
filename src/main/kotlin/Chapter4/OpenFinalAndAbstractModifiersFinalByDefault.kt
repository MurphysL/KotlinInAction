package Chapter4

/**
 * Created by MurphySL on 2017/5/27.
 */
interface Clickable2{
    fun click()
    fun showOff() = println("clickable")
}

class RichButton0 : Clickable2{ // 默认情况下 Kotlin 中所有类都是 final
    override fun click() = Unit
    open fun animate(){} // final 类中开放成员是禁止的
}

open class RichButton1 : Clickable2{
    final override fun click() = Unit // 禁止再次覆盖

    open fun animate(){}

    fun disable(){}
}