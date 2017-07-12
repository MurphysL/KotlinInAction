package DataStructure.Tree

/**
 * AVLNode
 *
 * Created by MurphySL on 2017/7/11.
 */
class AVLNode(val key : Int){
    var balance = 0
    var left : AVLNode? = null
    var right : AVLNode? = null
    var p : AVLNode? = null

    override fun toString(): String = "[$key] : balance[$balance]"
}

var head : AVLNode? = null

fun AVLNode?.insert(value : Int){
    val new : AVLNode = AVLNode(value)
    var node : AVLNode? = this
    var pre : AVLNode? = node

    while(node != null){
        pre = node
        if(node.key > value){
            node = node.left
        }else{
            node = node.right
        }
    }

    if(pre == null){
        head = new
    } else{
        if(value < pre.key){
            pre.left = new
        }else{
            pre.right = new
        }
    }
    new.p = pre // 设置前驱
}

fun AVLNode?.search(value : Int) : AVLNode?{
    var node: AVLNode? = this ?: return null // 结点为空

    while(node != null && node.key != value){
        if(node.key > value){
            node = node.left
        }else{
            node = node.right
        }
    }

    return node
}

fun AVLNode?.min() : AVLNode?{
    var node : AVLNode? = this
    var pre = node

    while(node != null){
        pre = node
        node = node.left
    }

    return pre
}

fun AVLNode?.max() : AVLNode?{
    var node : AVLNode? = this
    var pre  = node
    while(node != null){
        pre = node
        node = node.right
    }

    return pre
}

// 后继
fun AVLNode?.successor() : AVLNode?{
    var node : AVLNode? = this

    if(node!!.right != null) return node.right?.min()

    var pre = node.p
    while(pre != null && pre.right?.key == node!!.key){
        node = pre
        pre = pre.p
    }
    return pre
}

//前驱
fun AVLNode?.predecessor() : AVLNode?{
    var node : AVLNode? = this
    if(node!!.left != null) return node.left?.max()

    var pre = node.p
    while(pre != null && pre.left?.key == node!!.key){
        node = pre
        pre = pre.p
    }
    return pre
}

//移动子树
fun AVLNode.transplant(new : AVLNode?){
    val origin : AVLNode = this
    val pre = origin.p

    if(pre == null){
        head = new
    }else if(pre.left == origin){
        pre.left = new
        println(pre.left?.key)
    }else{
        pre.right = new
    }

    if(new != null)
        new.p = pre
}

fun AVLNode?.delete(value : Int){
    val node : AVLNode? = search(value) ?: return
    val min = node!!.right.min()

    if(node.left == null){
        node.transplant(node.right)
    }else if(node.right == null){
        node.transplant(node.left)
    }else{
        /**
         *           o   z
         *          /\
         *    l   o   o   r
         *           /\
         *    y    o   o
         *         \
         *         o   x
         */
        if(min != node.right){
            min?.transplant(min.right)
            min!!.right = node.right
            min.right!!.p = min
        }
        node.transplant(min)
        min!!.left = node.left
        min.left!!.p = min
    }
}

fun AVLNode?.midOrder(){
    if(this == null) return

    this.left.midOrder()
    println(this.toString())
    this.right.midOrder()
}

fun AVLNode?.preOrder(){
    if(this == null) return

    println(this.toString())
    this.left.preOrder()
    this.right.preOrder()
}

fun AVLNode?.postOrder(){
    if(this == null) return

    this.left.postOrder()
    this.right.postOrder()
    println(this.toString())
}

fun main(args: Array<String>) {
    head.insert(2)
    head.insert(1)
    head.insert(5)
    head.insert(3)
    head.insert(6)
    head.insert(4)

    head.delete(2)

    head.midOrder()
    head.postOrder()
    head.preOrder()
    head.successor()
    head.predecessor()

}