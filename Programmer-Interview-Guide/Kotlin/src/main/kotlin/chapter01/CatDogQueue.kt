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
    private val catIdxQueue = LinkedList<Int>()
    private val dogIdxQueue = LinkedList<Int>()
    private val idxPetMap = HashMap<Int, Pet>()
    private var idx = 0

    fun add(p: Pet) {
        if(isEmpty()) idx = 0
        when (p) {
            is Cat -> catIdxQueue.add(idx)
            is Dog -> dogIdxQueue.add(idx)
        }
        idxPetMap[idx] = p
        idx++
    }

    fun pollAll(): Pet? {
        val catIdx = catIdxQueue.peek()
        val dogIdx = dogIdxQueue.peek()
        if (dogIdx != null && (catIdx == null || catIdx > dogIdx)) {
            dogIdxQueue.pop()
            return idxPetMap[dogIdx]
        }
        if (catIdx != null && (dogIdx == null || dogIdx > catIdx)) {
            catIdxQueue.pop()
            return idxPetMap[catIdx]
        }
        throw NoSuchElementException()
    }

    fun pollDog(): Dog {
        val dogIdx = dogIdxQueue.pop()
        return idxPetMap[dogIdx] as Dog
    }

    fun pollCat(): Cat {
        val catIdx = catIdxQueue.pop()
        return idxPetMap[catIdx] as Cat
    }

    fun isEmpty(): Boolean {
        return catIdxQueue.isEmpty() && dogIdxQueue.isEmpty()
    }

    fun isDogEmpty(): Boolean {
        return dogIdxQueue.isEmpty()
    }

    fun isCatEmpty(): Boolean {
        return catIdxQueue.isEmpty()
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