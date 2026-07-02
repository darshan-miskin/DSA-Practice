package dsa.linkedlist

fun main(){
    val linkedList = LinkedList(1)
    for (i in 2 .. 10){
        linkedList.append(i)
    }
    linkedList.reverse()
}

fun LinkedList.reverse(){
    var reversed: LinkedList.Node? = null

    var slow: LinkedList.Node? = null
    var fast = this.head
    val tail = this.head

    this.printAll()

    while (fast!=null){
        reversed = fast
        fast = fast.next
        reversed.next = slow
        slow = reversed
    }

    this.head = reversed
    this.tail = tail

    this.printAll()
}