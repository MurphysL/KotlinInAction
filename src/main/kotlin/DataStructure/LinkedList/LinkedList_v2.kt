package DataStructure.LinkedList

/**
 * Circular, Double Linked List With a Sentinel
 *
 * Created by MurphySL on 2017/7/7.
 */
class Node_v2(val value : Int){
    var prev : Node_v2 = this
    var next : Node_v2 = this

    operator fun plusAssign(value : Int) = insert(value)

    operator fun minusAssign(value : Int) = delete(value)

    fun toList() : ArrayList<Int>{
        val list  = ArrayList<Int>()
        this.let {
            var node = head_v2.next

            while (node != head_v2){
                list.add(node.value)
                node = node.next
            }
            return list
        }
    }

    override fun toString(): String {
        return "[${this.prev.value}] <=> [${this.value}] <=> [${this.next.value}]"
    }

    private fun insert(value : Int){
        val node = Node_v2(value)
        node.next = head_v2.next
        node.next.prev = node
        head_v2.next = node
        node.prev = head_v2
    }

    private fun delete(value : Int) {
        val node = search_v2(value)
        if(node != head_v2 ){
            node.prev.next = node.next
            node.next.prev = node.prev
        }
    }
}

val head_v2 : Node_v2 = Node_v2(0) // 哨兵，作为哑对象，简化边界处理

fun search_v2(value : Int) : Node_v2{
    var node = head_v2.next
    while(node != head_v2 && node.value != value)
        node = node.next

    return node
}

fun main(args: Array<String>) {
    head_v2 += 1
    head_v2 += 2
    head_v2 += 3

    println(head_v2.toString())

    head_v2 -= 4

    head_v2.toList().forEach { println(it) }
}




