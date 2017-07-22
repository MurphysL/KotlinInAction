package Chapter3.k5

/**
 * Created by MurphySL on 2017/7/22.
 */
fun parsePath(path : String){
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir : $directory, name : $fileName, ext : $extension, full-name ; $fullName")
}

fun main(args: Array<String>) {
    parsePath("/Users/yole/kotlin-book/chapter.adoc")
}