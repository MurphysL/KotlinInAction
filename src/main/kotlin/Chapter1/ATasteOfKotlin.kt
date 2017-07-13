package Chapter1

/**
 * 1. val 一次赋值
 * 2. ?: （Elvis表达式） 非空使用原值，空使用 Elvis 表达式后的值
 *
 * Created by MurphySL on 2017/5/19.
 */
data class User(val name : String , val age : Int? = null)

fun main(args: Array<String>) {
    val users = arrayOf(User("pi", 20),
            User("zhen pi"))

    val oldest = users.maxBy { it.age ?: 0}

    println("the oldest is $oldest")
}
