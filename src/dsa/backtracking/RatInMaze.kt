package dsa.backtracking

import java.util.Stack

/**
 * Rat is placed at 0,0 index & has to reach N,N index for an N*N array.
 * The solution should return true if maze has a solution along with the path and
 * update the maze path to a value eg: 4, to denote traversal. If it is not traversable,
 * return false.
 */
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
    val path = Stack<Pair<Int, Int>>()

    println("traverseMaze: ${traverseMaze(path, visited, maze,0,0)}")

    path.forEach { print("${it.first} ${it.second} -> ") }
    println()

    maze.forEach { it.forEach { num ->  print("$num ") }; println() }

//    println()
//    println("count: $count")

//    visited.forEach { print("${it.first} ${it.second} -> ") }
}

var count = 0

/**
 * Traverses the maze and returns true if the maze has a solution, else false.
 * can move up, down, left & right
 */
fun traverseMaze(
    path: Stack<Pair<Int, Int>>,
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

        down = traverseMaze(path, visited, maze, i+1, j)
        right = traverseMaze(path, visited, maze, i, j+1)
        up = traverseMaze(path, visited, maze, i-1, j)
        left = traverseMaze(path, visited, maze, i, j-1)

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

