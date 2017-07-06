package DataStructure.Stack

/**
 * Stack
 * 泛型-》链表
 * Created by MurphySL on 2017/7/6.
 */
class Stack(val capacity : Int = 10){
    val values = IntArray(capacity)
    var top = 0 // 下一次插入位置

    operator fun plus(value : Int) = push(value)
}

fun Stack.empty() : Boolean = top <= 0

fun Stack.full() : Boolean = top >= capacity

fun Stack.pop() : Int {
    if(!empty()) {
        val value = values[-- top]
        return value
    }else{
        throw IndexOutOfBoundsException("栈下溢！")
    }
}

private fun Stack.push(value : Int){
    if(!full()){
        values[top ++] = value
    }else{
        throw IndexOutOfBoundsException("栈上溢！")
    }
}


fun main(args: Array<String>) {
    val stack = Stack(capacity = 2)
    stack + 1
    stack + 2

    println(stack.pop())
    println(stack.pop())
}