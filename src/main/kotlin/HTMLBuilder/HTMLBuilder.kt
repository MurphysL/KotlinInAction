package HTMLBuilder



/**
 * 1.泛型实例化，解决代码重复
 * 2.a 标签
 * Created by MurphySL on 2017/5/21.
 */
interface Element{
    fun render(builder : StringBuilder, indent : String)
}

open class TextElement(val name : String) : Element {
    override fun render(builder : StringBuilder, indent: String){
        builder.append("  $indent$name\n")
    }
}

open class Tag(name : String) : TextElement(name) {

    val children = arrayListOf<TextElement>()
    val attributes = hashMapOf<String, String>()

    fun <T : TextElement>initTag(t : T, init : T.()->Unit) : T{
        children.add(t)
        t.init()
        return t
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttr()}>\n")
        for (c in children){
            c.render(builder, indent+"  ")
        }
        builder.append("$indent</$name>\n")
    }

    fun renderAttr() : String?{
        val builder  = StringBuilder()
        for(a in attributes.keys){
            builder.append(" $a=\"${attributes[a]}\"")
        }
        return builder.toString()
    }

    override fun toString(): String {
        val builder = StringBuilder()

        render(builder,"")

        return builder.toString()
    }
}

open class TagWithText(name : String) : Tag(name){
    operator fun String.unaryPlus(){
        children.add(TextElement(this))
    }
}

class HTML : TagWithText("html"){
    fun head(init : HEAD.()->Unit) : HEAD = initTag(HEAD(), init)

    fun body(init : BODY.()->Unit) : BODY = initTag(BODY(), init)
}

class HEAD : TagWithText("head"){
    fun title(init : TITLE.()->Unit) : TITLE = initTag(TITLE(), init)
}

class BODY : TagWithText("body"){
    fun b(init : B.()->Unit) : B  = initTag(B(), init)

    fun p(init : P.()->Unit) : P = initTag(P(), init)

    fun h1(init : H1.()->Unit) : H1 = initTag(H1(), init)

    fun a(herf : String , init : A.()->Unit) : A{
        val a = initTag(A(), init)
        a.herf = herf
        return a
    }

}

class B : TagWithText("b")

class P : TagWithText("p")

class H1 : TagWithText("h1")

class A : TagWithText("a"){
    var herf : String
    get() = attributes["herf"]!!
    set(value) {attributes["herf"] = value}
}

class TITLE : TagWithText("title")

fun html(init : HTML.()->Unit) : HTML = HTML().apply(init)

val builder =
        html {
            head {
                title { +"HTML Builder" }
            }

            body {
                h1 { +"Hello Kotlin" }

                b { +"用于现代多平台应用的静态编程语言" }

                p { +"Kotlin 看起来是什么样的？" }

                a("https://bing.com") {

                }
            }
        }

fun main(args: Array<String>) {
    print(builder)
}