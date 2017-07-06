package Koans

/**
 * Created by MurphySL on 2017/5/24.
 */
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """|*(\S{3})|*"""

fun main(args: Array<String>) {
    getPattern().toRegex()
}