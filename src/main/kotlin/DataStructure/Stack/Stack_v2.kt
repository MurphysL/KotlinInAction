package DataStructure.Stack


/**
 * Stack -- Intruction to Algorithms
 *
 * Created by MurphySL on 2017/7/6.
 */
class Stack_v2(val capacity :Int = 10){
    val values = IntArray(capacity + 1) // values[0] 设为哨兵
    var top : Int = 0

    operator fun plus(value : Int) = push(value)
}

fun Stack_v2.empty() : Boolean = top == 0

fun Stack_v2.full() : Boolean = top == capacity

fun Stack_v2.pop() : Int{
    if(!empty()){
        top --
        return values[top + 1]
    }else{
        throw IndexOutOfBoundsException("underflow")
    }
}

fun Stack_v2.push(value : Int) {
    if(!full()){
        values[++ top] = value
    }else{
        throw IndexOutOfBoundsException("overflow")
    }
}

fun Stack_v2.size() : Int = top

fun main(args: Array<String>) {
    val stack = Stack_v2(3)

    stack + 1
    stack + 2
    stack + 3
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())

}