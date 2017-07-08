package DataStructure.Tree

/**
 * BST
 *
 * Created by MurphySL on 2017/7/8.
 */
class Node(val value : Int) {
    var left: Node? = null
    var right: Node? = null

    operator fun plusAssign(value : Int) = insert(value)

    private fun insert(value: Int){
        var node : Node? = this.left
        var pre : Node? = node // 父节点
        while (node != null) {
            pre = node
            if (node.value <= value) {
                node = node.right
            } else {
                node = node.left
            }
        }
        if(pre == null){ // 根节点为空
            this.left = Node(value)
        }else{
            if(pre.value <= value) pre.right = Node(value)
            else pre.left = Node(value)
        }
    }

    override fun toString(): String = "[${this.value}]"
}

fun Node.preOrder(){
    val node : Node? = this.left
    preOrderInner(node)
}
private fun preOrderInner(node : Node?){
    println(node.toString())
    if(node?.left != null)
        preOrderInner(node.left)
    if(node?.right != null)
        preOrderInner(node.right)
}

fun Node.midOreder(){
    val node = this.left
    midOrderInner(node)
}
private fun midOrderInner(node : Node?){
    if(node?.left != null) midOrderInner(node.left)

    println(node.toString())

    if(node?.right != null) midOrderInner(node.right)
}

fun Node.postOrder(){
    val node = this.left
    postOrderInner(node)
}
private fun postOrderInner(node : Node?){
    if(node?.left != null) postOrderInner(node.left)
    if(node?.right != null) postOrderInner(node.right)

    println(node.toString())
}

fun main(args: Array<String>) {
    val root : Node = Node(0)

    root += 3
    root += 2
    root += 1
    root += 5
    root += 4
    root += 6

    //root.preOrder()
    root.postOrder()
    //root.midOreder()
}