import java.util.*
import kotlin.collections.ArrayList

class Node(val data: Int){
    var left:Node?=null
    var right:Node?=null
}

fun getTreeRoot(indexes: Array<Array<Int>>):Node?{
    val root:Node?=Node(1)
    val list=ArrayList<Node?>()

    list.add(root)

    for (i in indexes.indices){
        for (j in indexes[i].indices){
            if(indexes[i][j]!=-1)
                list.add(Node(indexes[i][j]))
            else
                list.add(null)
        }
    }

    var left=1
    var right=2
    var i=0
    while (right<list.size){
        if(list[i]!=null) {
            list[i]?.left = list[left]
            list[i]?.right = list[right]
            i++
            left = right + 1
            right = left + 1
        }
        else
            i++
    }
    return root
}

fun swap(node: Node?, k: Int, level: Int) {
    if (node == null) return
    if (level % k == 0) {
        val temp = node.left
        node.left = node.right
        node.right = temp
    }
    swap(node.left, k, level + 1)
    swap(node.right, k, level + 1)
}

fun getTreeOrder(root: Node?):Int{
    var left=0
    var right=0
    if(root!=null){
        left=1+getTreeOrder(root.left)
        right=1+getTreeOrder(root.right)

    }
    return maxOf(left, right)
}

fun inOrder(root: Node?):String{
    var value=""
    var left=""
    var right=""
    if(root!=null){
        left=inOrder(root.left).trim()
        value=root.data.toString().trim()
        right=inOrder(root.right).trim()
    }
    return "$left $value $right ".trim()
}

fun swapNodes(indexes: Array<Array<Int>>, queries: Array<Int>): Array<ArrayList<Int>> {
    val root=getTreeRoot(indexes)
    var myRoot=root
    val treeOrder=getTreeOrder(root)
    val output=Array(queries.size){ ArrayList<Int>() }

    for (i in queries.indices){
        var k=queries[i]

        swap(myRoot,k,1)

        val array=inOrder(root).split(" ").map { it.trim().toInt() }.toTypedArray()
        output[i]= array.toList() as ArrayList<Int>
    }

    return output
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val indexes = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (indexesRowItr in 0 until n) {
        indexes[indexesRowItr] = scan.nextLine().trim().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val queriesCount = scan.nextLine().trim().toInt()

    val queries = Array<Int>(queriesCount, { 0 })
    for (queriesItr in 0 until queriesCount) {
        val queriesItem = scan.nextLine().trim().toInt()
        queries[queriesItr] = queriesItem
    }

    val result = swapNodes(indexes, queries)

    println(result.map { it.joinToString(" ") }.joinToString("\n"))
}
