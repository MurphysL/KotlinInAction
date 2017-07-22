package Chapter3.k2

/**
 * Created by MurphySL on 2017/5/20.
 */
fun <T>joinToString(collection: Collection<T>,
                    separator : String = ",",
                    prefix : String = "",
                    postfix : String = "") : StringBuilder{
    val result = StringBuilder()
    result.append(prefix)
    for((index, element) in collection.withIndex()){
        if(index > 0)
            result.append("$separator $element")
        else
            result.append("$element")
    }
    result.append(postfix)
    return result
}

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(joinToString(list, prefix = "[", postfix = "]"))
}