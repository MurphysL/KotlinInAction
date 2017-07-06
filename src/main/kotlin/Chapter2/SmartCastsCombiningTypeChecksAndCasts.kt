package Chapter2

/**
 * Created by MurphySL on 2017/5/22.
 */
interface Expr

class Child(val value : Int) : Expr

class Parent(val right : Expr , val left : Expr) : Expr

fun eval(e : Expr) : Int{
    if(e is Child){
        return e.value
    }

    if(e is Parent) {
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unkown Expr")
}

fun main(args: Array<String>) {
    println(eval(Parent(Parent(Child(2), Child(3)), Child(5))))
}