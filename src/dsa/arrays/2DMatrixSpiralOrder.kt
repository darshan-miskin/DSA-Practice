package dsa.arrays

/*
    Given a 2D matrix of size N x M, print all elements in spiral order starting from the top-left corner.

    Example
    Input:
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )
    Output:
    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

    Requirements

    Traverse the matrix in clockwise spiral order.

    Do not use extra matrix space.

    Time Complexity should be O(N * M).
*/

fun main(){
//    val matrix = arrayOf(
//        intArrayOf(1, 2, 3, 4),
//        intArrayOf(5, 6, 7, 8),
//        intArrayOf(9, 10, 11, 12),
//        intArrayOf(13, 14, 15, 16)
//    )
    val matrix = arrayOf(
        intArrayOf( 1,  2,  3,  4,  5,  6,  7,  8,  9, 10),
        intArrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
        intArrayOf(21, 22, 23, 24, 25, 26, 27, 28, 29, 30),
        intArrayOf(31, 32, 33, 34, 35, 36, 37, 38, 39, 40),
        intArrayOf(41, 42, 43, 44, 45, 46, 47, 48, 49, 50),
        intArrayOf(51, 52, 53, 54, 55, 56, 57, 58, 59, 60),
        intArrayOf(61, 62, 63, 64, 65, 66, 67, 68, 69, 70),
        intArrayOf(71, 72, 73, 74, 75, 76, 77, 78, 79, 80),
        intArrayOf(81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
        intArrayOf(91, 92, 93, 94, 95, 96, 97, 98, 99, 100),
    )

    var rowCounter = 0
    var colCounter = 0
    val matrixSize = matrix.size * matrix.first().size

    val visited = HashSet<String>()

    var isDecrement = false

    repeat(matrixSize){
        val current = matrix[colCounter][rowCounter]
        print("$current ")
        visited.add("${colCounter}x$rowCounter")

        if (rowCounter<matrix[colCounter].lastIndex && !visited.contains("${colCounter}x${rowCounter+1}") && !isDecrement){
            rowCounter++
        }
        else if (colCounter<matrix.lastIndex && !visited.contains("${colCounter+1}x$rowCounter") && !isDecrement){
            colCounter++
        }
        else if (rowCounter>0 && !visited.contains("${colCounter}x${rowCounter-1}")){
            rowCounter--
        }
        else if (colCounter>0 && !visited.contains("${colCounter-1}x$rowCounter")){
            colCounter--
            isDecrement = true
        }
        if (visited.contains("${colCounter-1}x$rowCounter"))
            isDecrement = false
    }
}