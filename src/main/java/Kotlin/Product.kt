package Kotlin

/**
 * Product
 *
 * Created by MurphySL on 2017/7/2.
 */
data class Product @JvmOverloads constructor(
        private val param1 : String,
        private val param2 : String = "param2",
        private val param3 : String = "param3")