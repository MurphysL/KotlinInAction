package DataStructure.Tree

/**
 * AVLNode
 *
 * Created by MurphySL on 2017/7/11.
 */
class AVLNode(val key : Int){
    var balance = 0
    var depth = 1
    var left : AVLNode? = null
    var right : AVLNode? = null
    var p : AVLNode? = null

    override fun toString(): String = "[$key]{\n balance : $balance,\n depth : $depth \n}"
}

var head : AVLNode? = null

fun AVLNode?.insert(value : Int){
    val node = this
    if(node == null){
        head = AVLNode(value)
        head!!.balance = 0
        head!!.depth = 1
    }else{
        if(node.key > value){
            if(node.left != null){
                node.left.insert(value)
            }else{
                node.left = AVLNode(value)
                node.left!!.p = node
            }
        }else{
            if(node.right != null){
                node.right.insert(value)
            }else{
                node.right = AVLNode(value)
                node.right!!.p = node
            }
        }
        node.calculateDepthAndBalance()
        node.balance()
    }
}

//右旋
fun AVLNode.rightRotate(){
    val node = this
    val left_node : AVLNode = node.left!!
    /**
     *               o
     *             /\
     *           o  o
     *         / \
     *       o   o
     *     /
     *   o
     */
    node.right = left_node.right
    left_node.right!!.p = node
    left_node.right = node
    left_node.right!!.p = left_node
    node.depth -= 2
    node.balance = 0
    left_node.balance = 0

    if(node.p == null){
        head = left_node
    }else{
        if(node.p!!.left == node){
            node.p!!.left = left_node
        }else{
            node.p!!.right = left_node
        }
    }
    left_node.left = node.left
}
//左旋
fun AVLNode.leftRotate(){
    val node = this
    val right_node : AVLNode= node.right!!

    node.left = right_node.left
    right_node.left!!.p = node
    right_node.left = node
    right_node.right!!.p = right_node
    //待修改
    node.depth -= 2
    node.balance = 0
    right_node.balance = 0

    if(node.p == null){
        head = right_node
    }else{
        if(node.p!!.right == node){
            node.p!!.right = right_node
        }else{
            node.p!!.left = right_node
        }
    }
    right_node.right = node.right
}

fun AVLNode.balance(){
    val node = this
    val left_node = node.left
    val right_node = node.right

    if(node.balance >= 2){
        if(left_node!!.balance > 0){ // 右旋
            node.rightRotate()
        }else{ // 左旋->右旋
            /**
             *               o
             *             /\
             *           o  o
             *         / \
             *       o   o
             *           \
             *           o
             */
            node.left = left_node.right
            left_node.right!!.p = node
            node.rightRotate()
        }
    }else if(node.balance <= -2){
        if(right_node!!.balance < 0){ // 左旋
            node.leftRotate()
        }else{ // 右旋 -> 左旋
            node.right = right_node.left
            right_node.left!!.p = node
            node.leftRotate()
        }
    }
}

fun AVLNode.calculateDepthAndBalance(){
    val left_node : AVLNode? = this.left
    val right_node : AVLNode? = this.right
    if(left_node != null && right_node != null){
        if(left_node.depth > right_node.depth){
            this.depth = left_node.depth + 1
        }else{
            this.depth = right_node.depth + 1
        }
        this.balance = left_node.depth - right_node.depth
    }else if(left_node != null){
        this.depth = left_node.depth + 1
        this.balance = 1
    }else if(right_node != null){
        this.depth = right_node.depth + 1
        this.balance = -1
    }else{
        this.depth = 1
        this.balance = 0
    }
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
    head.insert(5)
    head.insert(3)
//    head.insert(6)
    head.insert(2)
//    head.insert(4)
//    head.insert(1)

    //head.delete(2)

    head.midOrder()
    //head.postOrder()
    //head.preOrder()
    //head.successor()
    //head.predecessor()

}