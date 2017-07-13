package DataStructure.Tree

/**
 * Red Black Tree
 *
 * Created by MurphySL on 2017/7/10.
 */
enum class Color{
    RED, BLACK
}

class RBNode(val key : Int){
    var left : RBNode = nil
    var right : RBNode = nil
    var p : RBNode = nil
    var color : Color = Color.RED

    operator fun plusAssign(value: Int) = insert(value)

    private fun insert(value : Int){
        val new = RBNode(value)
        var node : RBNode = rb_root
        var pre : RBNode = nil

        while(node != nil){
            pre = node
            if(node.key > value){
                node = node.left
            }else{
                node = node.right
            }
        }
        new.p = pre // 双亲

        if(pre == nil){
            rb_root = new
        }else{
            if(value < pre.key){
                pre.left = new
            }else{
                pre.right = new
            }
        }

        insert_fix(new)
    }

    private fun insert_fix(node : RBNode) {
        var z  = node
        while(z.p.color == Color.RED){
            if(z.p == z.p.p.left){ //父结点为左子树
                val y = z.p.p.right // 叔结点
                if(y.color == Color.RED){
                    z.p.color = Color.BLACK
                    y.color = Color.BLACK
                    y.p.color = Color.RED
                    z = z.p.p
                }else if(z == z.p.right){ // 新结点为右结点，且叔结点为黑色
                    z = z.p //
                    z.leftRotate()
                }else{
                    z.p.color = Color.BLACK
                    z.p.p.color = Color.RED
                    z.p.p.rightRotate()
                }
            }else{ // 父结点为右子树
                val y = z.p.p.left // 叔结点
                if(y.color == Color.RED){
                    z.p.color = Color.BLACK
                    y.color = Color.BLACK
                    y.p.color = Color.RED
                    z = z.p.p
                }else if(z == z.p.left){ // 新结点为右结点，且叔结点为黑色
                    z = z.p //
                    z.rightRotate()
                }else{
                    z.p.color = Color.BLACK
                    z.p.p.color = Color.RED
                    z.p.p.leftRotate()
                }
            }
            rb_root.color = Color.BLACK
        }
    }

    override fun toString(): String  = "{key : $key, color : $color}"

}

val nil : RBNode = RBNode(0) // 哨兵，便于处理边界条件
var rb_root : RBNode= nil // 根节点

// 初始化红黑树
fun init(){
    nil.color = Color.BLACK
    rb_root.p = nil
    rb_root.left = nil
    rb_root.right = nil
}

fun RBNode.leftRotate(){
    val x = this
    val y = x.right

    x.right = y.left
    if(x.left != nil)
        y.left.p = x

    y.p = x.p

    if(x.p == nil){
        rb_root = y
    } else if(x.p.left == x){
        x.p.left = y
    }else{
        x.p.right = y
    }
    y.left = x
    x.p = y
}

fun RBNode.rightRotate(){
    val x = this
    val y = x.left

    x.left = y.right
    if(y.right != nil){
        y.right.p = x
    }

    y.p = x.p

    if(x.p == nil){
        rb_root = y
    }else if(x == x.p.left){
        x.p.left = y
    }else{
        x.p.right = y
    }

    y.right = x
    x.p = y
}

fun midOrder(tree : RBNode){
    if(tree == nil) return
    midOrder(tree.left)
    println(tree.toString())
    midOrder(tree.right)
}

fun preOrder(tree : RBNode){
    if(tree == nil) return
    println(tree.toString())
    preOrder(tree.left)
    preOrder(tree.right)
}

fun postOrder(tree : RBNode){
    if(tree === nil) return
    postOrder(tree.left)
    postOrder(tree.right)
    println(tree.toString())
}


fun main(args: Array<String>) {

    init()

    rb_root += 11
    rb_root += 2
    rb_root += 14
    rb_root += 1
    rb_root += 7
    rb_root += 5
    rb_root += 8
    rb_root += 4
    rb_root += 14
    rb_root += 15

    midOrder(rb_root)
}