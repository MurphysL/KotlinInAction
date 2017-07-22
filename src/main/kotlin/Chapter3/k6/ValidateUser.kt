package Chapter3.k6

/**
 * Created by MurphySL on 2017/7/22.
 */
class User(val id : Int, val name : String, val address : String)

private fun saveUser(user : User){
    if(user.name.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id} : empty Name")
    }

    if(user.address.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id} : empty Address")
    }
}

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
}