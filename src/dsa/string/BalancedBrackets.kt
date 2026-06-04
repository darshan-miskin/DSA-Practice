package dsa.string

import java.util.Stack

//Solution to https://leetcode.com/problems/valid-parentheses/description/

fun main(){
    val inputs = arrayListOf("[()()]{}", "][][", "<><>", "(<[>])")
    inputs.forEach { input->
        println(isBalanced(input))
    }
}

fun isBalanced(input: String): Boolean{
    val stack = Stack<Char>()
    val map = HashMap<Char,Char>()
    map[']'] = '['
    map[')'] = '('
    map['}'] = '{'
    map['>'] = '<'

    input.forEach {
        if (!map.containsKey(it)){
            stack.push(it)
        }
        else if(stack.isNotEmpty() && stack.peek()==map[it]){
            stack.pop()
        }
    }
    return stack.isEmpty()
}