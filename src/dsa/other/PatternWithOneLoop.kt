package dsa.other

/**
 * Print the following dsa.pattern using only one loop.
 *
 *              *
 *  //space
*               ***
 *  //space
 *              *****
 */
fun main(){
    var star = "*"
    var space = " "
    val input = 3

    var i = 1
    while (i<=input){
        if(i%2==0){
            println(space)
        } else {
            println(star)
        }
        space+=" "
        star+="*"
        i++
    }
}