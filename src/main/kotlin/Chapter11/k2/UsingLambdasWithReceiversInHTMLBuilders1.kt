package Chapter11.k2

/**
 * Created by MurphySL on 2017/5/21.
 */
open class Tag(val name : String){//声明属性以及从主构造函数初始化属性
    val children = arrayListOf<Tag>()

    fun <T : Tag>initTag(t : T, init : T.()->Unit) : T{
        children.add(t)
        t.init()
        return t
    }

    override fun toString(): String {
        return "<$name>${children.joinToString(separator = "")}</$name>"
    }
}

class TABLE : Tag("table") {
    fun tr(init : TR.()->Unit) : TR = initTag(TR(), init)
}

class TR : Tag("tr") {
    fun td(init : TD.()->Unit) : TD = initTag(TD(), init)
}

class TD : Tag("td")

fun table(init : TABLE.()->Unit) : TABLE = TABLE().apply(init) //接收者指定指定DSL

val html =
        table {
            for (i in 1..2){
                tr {
                    td {

                    }
                }
            }
        }

fun main(args: Array<String>) {
    println(html)
}