package dsa.other

fun main(){
    swap(10, 20)
}

//Swap two integers without using temporary variable
fun swap(num1: Int, num2:Int){
    var a = num1
    var b = num2

    println("Before swap \t a: $a \t b: $b")

    a = a + b
    b = a - b
    a = a - b

    println("After swap \t\t a: $a \t b: $b")
}