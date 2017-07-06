package DataStructure.IntructiontoAlgorithms

import DataStructure.Stack.*

/**
 * 用两个栈实现队列
 *
 * Created by MurphySL on 2017/7/6.
 */
fun main(args: Array<String>) {

    enqueue(1)
    enqueue(2)
    enqueue(3)
    enqueue(4)

    println(dequeue())
    println(dequeue())
    println(dequeue())
    println(dequeue())

}

val stack1 : Stack_v2 = Stack_v2(4)
val stack2 : Stack_v2 = Stack_v2(4)

fun enqueue(value : Int){
    stack1.push(value)
}

fun dequeue() : Int{
    if(stack2.empty()){
        if(!stack1.empty()){
            for(i in 1..stack1.size()){
                stack2.push(stack1.pop())
            }
            return stack2.pop()
        }else{
            throw IndexOutOfBoundsException("underflow")
        }
    }else{
        return stack2.pop()
    }
}
