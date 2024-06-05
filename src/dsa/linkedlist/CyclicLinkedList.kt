package dsa.linkedlist

import dsa.linkedlist.LinkedList.Node

fun main(){
    val linkedList = LinkedList(1)
    for (i in 2..6)
        linkedList.append(i)

    linkedList.tail?.next = linkedList.head

    val culpritNode = linkedList.findFaultyNode()

    if(culpritNode!=null)
        print("culprit node is ${culpritNode.value}")
    else
        print("Linked list is not cyclic")
}

/**
 * Returns the culprit node if cyclic or null if not
 *
 * Using fast & slow pointer, if linked list is cyclic both of the pointers
 * will point to the same node after n iterations. Where n is length of linked list.
 */
fun LinkedList.findFaultyNode(): Node?{
    var fast = head
    var slow = head
    while (fast?.next != null){
        fast = fast.next?.next
        slow = slow?.next
        if(fast == slow) return slow
    }
    return null
}