package Chapter2.k4

import java.util.*

/**
 * Created by MurphySL on 2017/7/22.
 */
fun main(args: Array<String>) {
    val binaryReps = TreeMap<Char, String>()

    for(i in 'A'..'Z'){
        val binary = Integer.toBinaryString(i.toInt())
        binaryReps[i] = binary
    }

    for((letter, binary) in binaryReps){
        println("$letter: $binary")
    }

}