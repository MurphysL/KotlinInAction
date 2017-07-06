package Chapter11

/**
 * Created by MurphySL on 2017/5/20.
 */
open class Tag(val name : String){
    private val children = ArrayList<Tag>()

    fun <T : Tag>initTag(t:T, init : T.()->Unit) : T{
        children.add(t)
        t.init()
        return t
    }

    override fun toString(): String {
        return "<$name>${children.joinToString()}</$name>"
    }
}

class Td : Tag("td")

class Tr : Tag("tr"){
    fun td(init : Td.()->Unit) : Td =  initTag(Td(), init)
}

class Table : Tag("table"){
    fun tr(init: Tr.() -> Unit) : Tr = initTag(Tr(), init)
}

fun table(init : Table.()->Unit) : Table = Table().apply(init)

fun html() =
        table {
            tr {
                td {

                }
            }
        }

fun main(args: Array<String>) {
    println(html())
}