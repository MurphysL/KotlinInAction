/**
 * Created by MurphySL on 2017/7/2.
 */
class  Test @JvmOverloads constructor(val a : Int = 10, val b : Int = 20, val c : Int= 30, val d : String="40"){
    override fun toString(): String {
        return "Test(a=$a, b=$b, c=$c, d='$d')"
    }
}