package DataStructure.LinkedList

/**
 * Double Linked List
 *
 * head -> node1 <=> node2 <=> node3 -> NIL
 * Created by MurphySL on 2017/7/7.
 */
class Node(val key : Int){
    var prev : Node? = null
    var next : Node? = null

    operator fun plus(value : Int) = insert(value)
    operator fun minus(value : Int) = delete(value)
}

val head : Node = Node(0)

fun insert(value : Int){
    val node : Node = Node(value)
    if(head.next != null){
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }else{
        head.next = node
    }
}

fun search(value : Int) : Node?{
    var node = head.next

    while(node != null){
        if(node.key == value)
            return node
        else
            node = node.next
    }
    return null
}

fun delete(value : Int){
    var node : Node? = search(value)

    if(node != null){
        println(node.prev?.key)
        if(node.prev != null){
            node.prev?.next = node.next
        }else{
            head.next = node.next
        }

        if(node.next != null){
            node.next?.prev = node.prev
        }
        node = null
    }

}

fun all(){
    var node  = head.next
    while(node != null){
        println(node.key)
        node = node.next
    }
}

fun main(args: Array<String>) {

    head + 1
    head + 2
    head + 3
    head - 3

    all()

}
