package Chapter3.k6

/**
 * Created by MurphySL on 2017/7/22.
 */
fun saveUser2(user : User){
    fun validate(user : User, value : String, fieldName : String){
        if(value.isEmpty()){
            throw IllegalArgumentException("Can't save user ${user.id}")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun main(args: Array<String>) {
    saveUser2(User(1, "", ""))
}
