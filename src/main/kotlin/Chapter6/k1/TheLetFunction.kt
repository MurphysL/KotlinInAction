package Chapter6.k1

/**
 * Created by MurphySL on 2017/5/23.
 */
fun sendEmail(email : String){
    println("send email to $email")
}

fun main(args: Array<String>) {
    val email = "111111@qq.com"
    sendEmail(email)

    val email2 : String? = null
    email2?.let { sendEmail(it) }

    println("send all emails")
}