package dsa.linkedlist

import dsa.linkedlist.LinkedList.Node

fun main(){
    val myLinkedList = LinkedList(1)

    myLinkedList.append(2)
    myLinkedList.append(3)
    myLinkedList.append(4)
    myLinkedList.append(5)

    println("1 -> 2 -> 3 -> 4 -> 5")
    println("Middle Node: " + myLinkedList.findMiddleNode()?.value)

    myLinkedList.append(6)

    println("===========================")
    println("1 -> 2 -> 3 -> 4 -> 5 -> 6")
    println("Middle Node: " + myLinkedList.findMiddleNode()?.value)
}

fun LinkedList.findMiddleNode(): Node? {
    var fastTemp: Node? = head
    var slowTemp: Node? = head
    while (fastTemp?.next != null) {
        fastTemp = fastTemp.next?.next
        slowTemp = slowTemp?.next
    }
    return slowTemp
}