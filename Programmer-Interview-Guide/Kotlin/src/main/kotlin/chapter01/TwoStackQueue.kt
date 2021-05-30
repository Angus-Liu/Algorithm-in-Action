package chapter01

import java.util.*

/**
 * 由两个栈组成的队列
 * 题目：编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 */
class TwoStackQueue {
    private val pushStack = LinkedList<Int>()
    private val popStack = LinkedList<Int>()

    fun add(num: Int) {
        pushStack.add(num)
    }

    fun poll(): Int {
        pushToPop()
        return popStack.poll()
    }

    fun peek(): Int {
        pushToPop()
        return popStack.peek()
    }

    fun isEmpty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }

    private fun pushToPop() {
        if (popStack.isEmpty() && pushStack.isNotEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.add(pushStack.pop())
            }
        }
    }
}

fun main() {
    val stack = TwoStackQueue()
    stack.add(10)
    stack.add(2)
    stack.add(2)
    // ------
    stack.poll()
    // ------
    stack.add(6)
    stack.add(1)
    stack.add(5)

    while (!stack.isEmpty()) {
        println("${stack.peek()} - ${stack.poll()}")
    }
}