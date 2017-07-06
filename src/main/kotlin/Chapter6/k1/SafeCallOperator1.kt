package Chapter6.k1

/**
 * Created by MurphySL on 2017/5/21.
 */
data class Employee(val name : String, val manager: Employee?)

fun managerName(employee: Employee) : String? = employee.manager?.name

fun main(args: Array<String>) {
    val ceo = Employee("Pichai" , null)
    val employee = Employee("joy", ceo)

    println(managerName(ceo))
    println(managerName(employee))
}