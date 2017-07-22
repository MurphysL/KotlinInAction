package Chapter2.k4

/**
 * when 也可以用来取代 if-else 链。
 * 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支。
 *
 * Created by MurphySL on 2017/7/22.
 */
fun fizzBuzz(i : Int) : String =
        when{
            i % 3 == 0 && i % 5 == 0 ->"FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }

fun main(args: Array<String>) {
    for(i in 1..100 ){
        println(fizzBuzz(i))
    }

    for(i in 100 downTo 1 step 2){
        println(i)
    }
}