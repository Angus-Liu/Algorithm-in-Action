package chapter01

import java.util.*

/**
 * 猫狗队列
 * 实现一种狗猫队列的结构，要求如下：
 * - 用户可以调用 add 方法将 cat 类或 dog 类的实例放入队列中；
 * - 用户可以调用 pollAll 方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * - 用户可以调用 pollDog 方法，将队列中 dog 类的实例按照进队列的先后顺序依次弹出；
 * - 用户可以调用 pollCat 方法，将队列中 cat 类的实例按照进队列的先后顺序依次弹出；
 * - 用户可以调用 isEmpty 方法，检查队列中是否还有 dog 或 cat 的实例；
 * - 用户可以调用 isDogEmpty 方法，检查队列中是否有 dog 类的实例；
 * - 用户可以调用 isCatEmpty 方法，检查队列中是否有 cat 类的实例。
 */

open class Pet(val type: String) {
    override fun toString(): String {
        return type
    }
}

class Dog : Pet("dog")

class Cat : Pet("cat")

class CatDogQueue {
    private val catIndexQueue = LinkedList<Int>()
    private val dogIndexQueue = LinkedList<Int>()
    private val indexPetMap = HashMap<Int, Pet>()

    private var index = 0

    fun add(p: Pet) {
        if(isEmpty()) index = 0
        when (p) {
            is Cat -> catIndexQueue.add(index)
            is Dog -> dogIndexQueue.add(index)
        }
        indexPetMap[index] = p
        index++
    }

    fun pollAll(): Pet? {
        val catIndex = catIndexQueue.peek()
        val dogIndex = dogIndexQueue.peek()
        if (dogIndex != null && (catIndex == null || catIndex > dogIndex)) {
            dogIndexQueue.pop()
            return indexPetMap[dogIndex]
        }
        if (catIndex != null && (dogIndex == null || dogIndex > catIndex)) {
            catIndexQueue.pop()
            return indexPetMap[catIndex]
        }
        throw NoSuchElementException()
    }

    fun pollDog(): Dog {
        val dogIndex = dogIndexQueue.pop()
        return indexPetMap[dogIndex] as Dog
    }

    fun pollCat(): Cat {
        val catIndex = catIndexQueue.pop()
        return indexPetMap[catIndex] as Cat
    }

    fun isEmpty(): Boolean {
        return catIndexQueue.isEmpty() && dogIndexQueue.isEmpty()
    }

    fun isDogEmpty(): Boolean {
        return dogIndexQueue.isEmpty()
    }

    fun isCatEmpty(): Boolean {
        return catIndexQueue.isEmpty()
    }
}

fun main() {
    val queue = CatDogQueue()
    queue.add(Cat())
    queue.add(Dog())
    queue.add(Cat())
    queue.add(Dog())
    queue.add(Cat())
    queue.add(Cat())
    println(queue.pollCat())
    println("----")
    println(queue.pollDog())
    println(queue.pollDog())
    println("----")
    queue.add(Dog())
    queue.add(Cat())
    while (!queue.isEmpty()) {
        val p = queue.pollAll()
        println(p)
    }
    queue.add(Dog())
    queue.add(Cat())
    while (!queue.isEmpty()) {
        val p = queue.pollAll()
        println(p)
    }
}