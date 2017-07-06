package Chapter6.k1

/**
 * Created by MurphySL on 2017/5/23.
 */
class Address (val streetAddr : String, val city : String , val country : String)

class Company (val name : String, val addr : Address)

class Person (val name : String , val company : Company?)

fun Person.getCountryName() : String?{
    val country = this.company?.addr?.country
    return country ?: "Unkown"
}

fun main(args: Array<String>) {
    val person = Person("Jake Wharton", null)
    println(person.getCountryName())
}