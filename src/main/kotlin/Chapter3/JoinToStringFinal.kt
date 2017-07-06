package Chapter3

/**
 * 扩展函数
 * Created by MurphySL on 2017/5/20.
 */
fun <T>Collection<T>.joinToStringFinal(
        separator:String = ",",
        prefix:String = "(",
        postfix:String = ")"
):String{
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if(index > 0)
            result.append("$separator $element")
        result.append("$element")
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val list = listOf("one", "two", "three")
    println(list.joinToStringFinal(separator = ";"))
}