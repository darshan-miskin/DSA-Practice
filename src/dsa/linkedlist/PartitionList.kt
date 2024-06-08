package dsa.linkedlist

/**
 * You have a singly linked list. Given a value x you need to rearrange the linked list
 * such that all nodes with a value less than x come before all nodes with a value
 * greater than or equal to x.
 * Additionally, the relative order of nodes in both partitions should remain unchanged.
 *
 * Constraints:
 * The solution should traverse the linked list at most once.
 * The solution should not create a new linked list.
 * The solution should not use tail pointer.
 *
 * Input:
 * A singly linked list and an integer x.
 *
 * Output:
 * The same linked list but rearranged as per the above criteria.
 *
 * Function signature:
 * fun partitionList(int x): Unit
 *
 * Details:
 * The function partitionList takes an integer x as a parameter and modifies the current
 * linked list in place according to the specified criteria. If the linked list is empty
 * (i.e., head is null), the function should return immediately without making any changes.
 *
 * Example 1:
 * Input:
 * Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5
 * Process:
 * Values less than 5: 3, 2, 1
 * Values greater than or equal to 5: 8, 5, 10
 * Output:
 * Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10
 *
 *
 * Example 2:
 * Input:
 * Linked List: 1 -> 4 -> 3 -> 2 -> 5 -> 2 x: 3
 * Process:
 * Values less than 3: 1, 2, 2
 * Values greater than or equal to 3: 4, 3, 5
 * Output:
 * Linked List: 1 -> 2 -> 2 -> 4 -> 3 -> 5
 *
 */

fun LinkedList.partitionList(x: Int){
    if(head==null) return

    var temp = head
    val lHead = Node(0)
    val gHead = Node(0)
    var lesserList = lHead
    var greaterList = gHead

    while (temp!=null){
        val current = temp
        temp = temp.next
        current.next = null

        if(current.value<x){
            lesserList.next = current
            lesserList = lesserList.next!!
        }
        else {
            greaterList.next = current
            greaterList = greaterList.next!!
        }
    }

    lesserList.next = gHead.next
    head = lHead.next
}

fun main(){
    val ll = LinkedList(3)
    ll.append(5)
    ll.append(8)
    ll.append(10)
    ll.append(2)
    ll.append(1)

    println("LL before partitionList:")
    ll.printList()
    // Output: 3 5 8 10 2 1

    ll.partitionList(5)

    println("LL after partitionList:")
    ll.printList()
    // Output: 3 2 1 5 8 10


    ll.partitionList(2)

    println("LL after partitionList:")
    ll.printList()
    // Output: 1 3 2 5 8 10

}