package chapter01

import java.util.*

/**
 * 设计一个有 getMin 功能的栈
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：
 *  1.pop、push、getMin 操作的时间复杂度都是 O(1)。
 *  2.设计的栈类型可以使用现成的栈结构。
 */
class GetMinStack {
    /** 保存所有元素 */
    private val dataStack = LinkedList<Int>()

    /** 保存最小元素 */
    private val minStack = LinkedList<Int>()

    fun push(num: Int) {
        // 保存数据
        dataStack.push(num)
        // 维护现阶段最小值
        val min = getMin()
        if (min == null || num <= min) minStack.push(num)
    }

    fun pop(): Int {
        val num = dataStack.pop()
        val min = getMin()
        if (min != null && num == min) minStack.pop()
        return num
    }

    fun getMin(): Int? {
        return minStack.peek()
    }
}

fun main() {
    val stack = GetMinStack()

    stack.push(10)
    stack.push(2)
    stack.push(2)
    stack.push(6)
    stack.push(1)
    stack.push(5)

    for (i in 0 until 6) {
        println("${stack.getMin()} - ${stack.pop()}")
    }
}