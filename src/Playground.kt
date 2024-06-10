import java.util.Stack

fun main(){
    val maze = mutableListOf(
        mutableListOf(1, 0, 1, 1, 1, 1),
        mutableListOf(1, 1, 1, 0, 0, 1),
        mutableListOf(0, 1, 0, 0, 0, 1),
        mutableListOf(1, 1, 1, 1, 1, 1),
        mutableListOf(1, 0, 0, 1, 0, 0),
        mutableListOf(1, 1, 1, 1, 1, 1)
    )

    val visited = HashSet<Pair<Int,Int>>()

    println("traverseMaze: ${traverseMaze(visited, maze,0,0)}")

    path.forEach { print("${it.first} ${it.second} -> ") }
    println()

    maze.forEach { it.forEach { num ->  print("$num ") }; println() }

//    println()
//    println("count: $count")

//    visited.forEach { print("${it.first} ${it.second} -> ") }
}

val path = Stack<Pair<Int, Int>>()
var count = 0

/**
 * Traverses the maze and returns true if the maze has a solution, else false.
 * can move up, down, left & right
 */
fun traverseMaze(
    visited: HashSet<Pair<Int, Int>>,
    maze: MutableList<MutableList<Int>>,
    i: Int, j: Int
): Boolean {
    var right = false
    var down = false
    var up = false
    var left = false
    val pair = Pair(i, j)

    path.push(pair)
    if ((i > -1 && j > -1 && i < maze.size && j < maze[i].size) &&
        maze[i][j] == 1 && !visited.contains(pair)
    ) {

//        count ++
        val pathVal = maze[i][j]

        // update path value to indicate traversal
        maze[i][j] = 4

        visited.add(pair)
        if(i==j && i==maze.lastIndex){
            println()
            println("maze completed")
            return true
        }

        down = traverseMaze(visited, maze, i+1, j)
        right = traverseMaze(visited, maze, i, j+1)
        up = traverseMaze(visited, maze, i-1, j)
        left = traverseMaze(visited, maze, i, j-1)

        // revert path value. indicating dead end
        if(!down && !right && !up && !left) {
            maze[i][j] = pathVal
        }
    }

    //dead end so remove the current path
    if(!down && !right && !up && !left) {
        path.pop()
    }

    return down || right || left || up
}

