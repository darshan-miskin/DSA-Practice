package dsa.linkedlist

class NodeL(val nodeName:String){
    var nextNode: NodeL?=null
}

fun main(){
    val node1= NodeL("1")
    val node2= NodeL("2")
    val node3= NodeL("3")
    val node4= NodeL("4")
    val node5= NodeL("5")
    val node6= NodeL("6")

    node1.nextNode=node2
    node2.nextNode=node3
    node3.nextNode=node4
    node4.nextNode=node5
    node5.nextNode=node6
    node6.nextNode=node1

    val culpritNode= findFaultyNode(node1)

    if(culpritNode!=null)
        print("culprit node is ${culpritNode.nodeName}")
    else
        print("Linked list is not cyclic")
}

/**
 * Returns the culprit node if cyclic or null if not
 */
fun findFaultyNode(rootNode: NodeL?): NodeL?{
    var isFound=false
    var thisNode=rootNode
    var nextNode=rootNode?.nextNode
    val set=HashSet<NodeL?>()

    set.add(thisNode)

    while (nextNode!=null){
        if(!set.contains(nextNode)){
            set.add(nextNode)

            thisNode=nextNode
            nextNode=thisNode.nextNode
        }
        else{
            isFound=true
            nextNode=null
        }
    }

    return if (isFound) thisNode else null
}