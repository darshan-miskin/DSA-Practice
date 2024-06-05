package dsa.linkedlist

import dsa.linkedlist.LinkedList.Node

fun main(){
    val myLinkedList = LinkedList(1)
    myLinkedList.append(2)
    myLinkedList.append(3)
    myLinkedList.append(4)
    myLinkedList.append(5)

    val k = 2
    val result: Int? = myLinkedList.findKthFromEnd(k)?.value

    println(result) // Output: 4
}

/**
 * using fast and slow pointer method to find kth element from end in O(n) time
 * without knowing the length of the linked list.
 *
 * We traverse the fast pointer till we reach k, then we traverse both the fast & slow
 * pointer until fast reaches the end. With this, the slow pointer will reach
 * the kth element from end.
 */
fun LinkedList.findKthFromEnd(k: Int): Node? {
    var fast = head
    var slow = head
    for(i in 0 until k){
        fast = fast?.next
        if (fast == null) return null
    }
    while (fast!=null){
        fast = fast.next
        slow = slow?.next
    }
    return slow
}