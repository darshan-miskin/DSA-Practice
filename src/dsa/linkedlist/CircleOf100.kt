package dsa.linkedlist

/**
 * 100 people are standing in a circle each represented by the respective position they stand at i.e 1 to 100.
 * Person at position 1 passes the stick to the adjacent person skipping one person. i.e 1 passes it to 3 &
 * 3 passes it to 5. Person at position 99 will pass it to person at 1, skipping 100.
 * The stick is passed until only one person is remaining. We have to find, who is the last person remaining.
 */
fun main(){
   val head = init(100)

    var temp: Node? = head
    println(" ${temp?.index}")
    while (temp?.next!=temp){
        temp?.next = temp?.next?.next
        print(" ${temp?.next?.index}")
        temp = temp?.next
    }

    println()
    print(" ${temp?.index}")
}

fun init(noOfPeople: Int): Node {
    var head: Node? = Node()
    var tail = head
    for (i in 2..noOfPeople){
        val next = Node()
        next.index = i
        tail?.next = next
        tail = tail?.next
    }
    tail?.next = head
    return head!!
}

fun printll(head: Node?){
    var tempPrint = head
    for (i in 1..(input *2)+10){
        print(" ${tempPrint?.index} \t ${tempPrint?.next} \n ")
        tempPrint=tempPrint?.next
    }
    println()
    println()
}

const val input = 100

class Node{
    var index: Int = 1
    var next: Node? = null
}