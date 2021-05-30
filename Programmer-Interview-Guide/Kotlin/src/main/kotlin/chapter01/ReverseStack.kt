package chapter01

import java.util.*

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 题目：一个栈依次压入 1、2、3、4、5，那么从栈顶到栈底分别为 5、4、3、2、1。将这个栈转置后，
 *      从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 */

/**
 * 返回栈底元素
 */
fun popLast(stack: LinkedList<Int>): Int {
    val num = stack.pop()
    if (stack.isEmpty()) return num
    val last = popLast(stack)
    stack.push(num)
    return last
}

/**
 * 逆序一个栈
 */
fun reverse(stack: LinkedList<Int>) {
    if (stack.isEmpty()) return
    // 每次弹出栈底元素
    val last = popLast(stack)
    // 当栈不为空时，递归处理
    reverse(stack)
    // 将栈底元素重新压入
    stack.push(last)
}

fun main() {
    val stack = LinkedList<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack)
    // 逆序
    reverse(stack)
    println(stack)
}