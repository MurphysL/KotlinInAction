package Chapter4.k4

import java.io.File

/**
 * Created by MurphySL on 2017/5/27.
 */
object CaseFilePath : Comparator<File>{
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(CaseFilePath.compare(File("/FILE"), File("/file")))
    val list = listOf(File("/Z"), File("/A"))
    println(list.sortedWith(CaseFilePath))
}