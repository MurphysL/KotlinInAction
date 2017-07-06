package Chapter3

/**
 * Created by MurphySL on 2017/5/20.
 */
val kotlinlogo : String = """| //
                            .|//
                            .|/ \"""

fun main(args: Array<String>) {
    println(kotlinlogo.trimMargin("."))
}