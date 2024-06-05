package dsa.linkedlist

class LinkedList(value: Int) {
    var head: Node?
        private set
    var tail: Node?
        private set

    inner class Node(var value: Int) {
        var next: Node? = null
    }

    init {
        val newNode: Node = Node(value)
        head = newNode
        tail = newNode
    }

    fun printList() {
        var temp = head
        while (temp != null) {
            println(temp.value)
            temp = temp.next
        }
    }

    fun printAll() {
        if (head == null) {
            println("Head: null")
            println("Tail: null")
        } else {
            println("Head: " + head!!.value)
            println("Tail: " + tail!!.value)
        }
        println("\nLinked List:")
        if (head == null) {
            println("empty")
        } else {
            printList()
        }
    }

    fun makeEmpty() {
        head = null
        tail = null
    }

    fun append(value: Int) {
        val newNode: Node = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            tail = newNode
        }
    }
}

