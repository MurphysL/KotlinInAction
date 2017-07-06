package DataStructure.Queue


/**
 * Queue
 *  LinkedList Deque
 * Created by MurphySL on 2017/7/6.
 */
class Deque(val capacity : Int = 10){
    var front : Int = 0 // 下一位置
    var rear : Int = 0 //下一位置
    val values = IntArray(capacity)

    operator fun plus(value : Int) = enqueue(value)
}

fun Deque.empty() : Boolean = front == rear

fun Deque.full() : Boolean = (rear + 1)%capacity == front // 空一位,便于判断空与满

private fun Deque.enqueue(value : Int){
    if(!full()){
        values[rear] = value
        rear = (++ rear)%capacity
    }else{
        throw IndexOutOfBoundsException("队列满,无法入队！")
    }
}

fun Deque.dequeue() : Int{
    if(!empty()){
        val value = values[front]
        front = (++ front)%capacity
        return value
    }else{
        throw IndexOutOfBoundsException("队列空,无法出队！")
    }
}

fun main(args: Array<String>) {
    val queue = Deque(4)

    queue + 1
    queue + 2
    queue + 3
    println("dequeue ${queue.dequeue()}")
    queue + 4
    println("dequeue ${queue.dequeue()}")
    println("dequeue ${queue.dequeue()}")
    println("dequeue ${queue.dequeue()}")

}