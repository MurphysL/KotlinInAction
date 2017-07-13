package Chapter2.k2

/**
 * 改变访问器的可见性
 *
 * Created by MurphySL on 2017/7/12.
 */
class Person(val name : String, val age : Int){
    var sex : String = "男"
    private set

    var weight : Int = 140
    set(value) {

    }
}

fun main(args: Array<String>) {
    val person = Person("pi", 20)
    //person.sex = "女"
}