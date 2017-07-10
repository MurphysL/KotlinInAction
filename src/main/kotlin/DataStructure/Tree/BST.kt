package DataStructure.Tree

/**
 * BST
 *
 *  delete 删除节点待修改
 * Created by MurphySL on 2017/7/8.
 */
class BSTNode(var key : Int){
    var left : BSTNode? = null
    var right : BSTNode? = null
    var p : BSTNode? = null

    override fun toString(): String {
        return "[${this.key}]"
    }
}

var root : BSTNode? = null

fun BSTNode?.search(value : Int) : BSTNode?{
    var node: BSTNode? = this ?: return null

    while(node != null && node.key != value){
        if(node.key <= value)
            node = node.right
        else
            node = node.left
    }
    return node
}

//中序后继
fun BSTNode?.successor() : BSTNode?{
    var node : BSTNode? = this
    if(node?.right != null)
        return node.right.min()

    var pre = node?.p
    while(pre != null && pre.right?.key == node?.key){ //node 的最低层祖先
        node = pre
        pre = pre.p
    }
    return pre
}

//中序前驱
fun BSTNode?.predecessor() : BSTNode?{
    var node : BSTNode? = this
    if(node?.left != null)
        return node.left.max()

    var pre = node?.p
    while(pre != null && pre.left?.key == node?.key){
        node = pre
        pre = pre.p
    }
    return pre
}

fun BSTNode?.min() : BSTNode?{
    var node = this
    var pre = node
    while(node != null){
        pre = node
        node = node.left
    }
    return pre
}

fun BSTNode?.max() : BSTNode?{
    var node = this
    var pre = node
    while(node != null){
        pre = node
        node = node.right
    }
    return pre
}

fun BSTNode?.insert (value : Int){
    var node : BSTNode? = this
    var pre = this
    val n = BSTNode(value)

    while(node != null){
        pre = node
        if(value >= node.key)
            node = node.right
        else
            node = node.left
    }

    n.p = pre
    if(pre == null){
        root = n
    } else if(pre.key <= value){
        pre.right = n
    } else if(pre.key > value){
        pre.left = n
    }
}

fun BSTNode?.delete (value : Int){
    val node = this.search(value) ?: return
    val pre = node.p
    if(pre != null){ // 非根节点
        if(node.left == null && node.right == null){ // 无子结点
            if(pre.key > node.key){
                pre.left = null
            }else{
                pre.right = null
            }
        }else if(node.right != null){ // 有右子结点
            val min = node.right.min()
            node.key = min!!.key
            if(min === node.right.min())
                node.right = null
            else
                min.p!!.left = null
        }else{
            val max = node.left.max() // 只有左子结点
            node.key = max!!.key
            if(max === node.left){
                node.left = null
            }else{
                max.p!!.left = null
            }
        }
    }else{
        root = null
    }
}

fun BSTNode?.midOrder(){
    if(this != null){
        this.left.midOrder()
        println(this.toString())
        this.right.midOrder()
    }
}

fun BSTNode?.preOrder(){
    if(this != null){
        println(this.toString())
        this.left.preOrder()
        this.right.preOrder()
    }
}

fun BSTNode?.postOrder(){
    if(this != null){
        this.left.postOrder()
        this.right.preOrder()
        println(this.toString())
    }
}




fun main(args: Array<String>) {
    root.insert(15)
    root.insert(6)
    root.insert(18)
    root.insert(17)
    root.insert(20)
    root.insert(3)
    root.insert(7)
    root.insert(2)
    root.insert(4)
    root.insert(13)
    root.insert(9)
    //root.midOrder()
    //println(root.max()?.key)
    //println(root.search(5)?.key)
    //println(root.search(9)?.max())

    //println(root.search(18)?.successor()?.key)
    //println(root.search(17)?.predecessor()?.key)
    root.delete(6)
    root.midOrder()

}