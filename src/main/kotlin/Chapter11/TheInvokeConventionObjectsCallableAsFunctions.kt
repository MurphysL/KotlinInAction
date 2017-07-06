package Chapter11

/**
 * Created by MurphySL on 2017/5/21.
 */
class Greeter{
    operator fun invoke(name : String){
        println("greeting,$name")
    }
}

fun main(args: Array<String>) {
    val greeter = Greeter()
    greeter("chen")
}