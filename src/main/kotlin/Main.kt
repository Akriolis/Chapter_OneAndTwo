import java.io.BufferedReader
import java.io.StringReader
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.reflect.Executable
import java.nio.Buffer
import java.util.TreeMap


fun main(){
    val persons = listOf<Person>(
        Person("Alice"),
        Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")

    // statically typed

    // type interference - the ability of the compiler to determine types from cintext

    fun findAlice() = persons.filter {it.name == "Alice"}

    val name = persons[0].name;

    println(max(2,5));

    var sum = 0
    var i = 0
    while (i<= 100){
        sum += i
        i++
        if (sum > 1000){
            break
        }
    }
    println(sum)

    /*var count = 0
    while (true){
        var input = readLine()!!.toInt()

        if(input == 0){
            break
        }
        count++
    }
    println(count)*/

    var num = 1
    var result = ""
    when{
        num == 0 -> result = "Zero"
        num > 0 -> result = "Positive"
        num < 0 -> result = "Negative"
    }
    println(result)

    val testName = "Victor"
    for (x in testName){
        println(x)
    }

    println(testName[0])

    val x = arrayOf(8,9,10,24)
    if (100 in x){
        println("Yes")
    } else{
        println("Nope")
    }

    var r = 2..6
    for (x in r){
        if (10%x in r){
            println(x)
        }
    }

    val f = {a: Int, b: Int -> a + b}

    val b: (Int, Int) -> Int
    b = {a, b -> a * b}

    x.forEach { println(it * 10) }

    fun apply (x: Int, action: (Int) -> Int): Int{
        return action(x)
    }

    println(apply(8) { x -> x * 2 })

    var testTest = Pet("Biba")

    testTest.setAge = 21
    println(testTest.getAge)
    testTest.setAge2(20)
    println(testTest.getAge)

    val answer: Int
    if (true){
        answer = 10
    } else {
        answer = 5
    }

    val testRectangle: Rectangle = Rectangle(10,20)

    while (true){
        val myTest = testRectangle.createRandomRectangle()
        if (myTest.isSquare){
            println("Bingo!")
            break
        }
    }

    println(Color.RED.rgb())

    println(getMnemonic(Color.INDIGO))

    println(getWarmth(Color.RED))

    println(mix(Color.BLUE,Color.YELLOW))

    println(mixOptimized(Color.VIOLET, Color.BLUE))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println(eval3(Sum(Num(1), Num(2))))

    println(evalWithLogging(Sum(Sum(Num(1),Num(2)), Num(3))))

    for (i in 1..100){
        println(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 2){
        println(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps){
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()){
        println("$index: $element")
    }

    println(isLetter('q'))
    println(isNotDigit('x'))

    println(recognize('A'))

    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java", "Scala"))

    /*val number = readLine()?.toInt()
    val percentage =
        if (number in 0..100)
        "bingo!"
        else
            throw IllegalArgumentException(
                "A percentage value must be between 0 and 100: $number"
            )
    println(percentage)*/

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))

    val reader2 = BufferedReader(StringReader("Not a number"))
    readNumber2(reader2)

}
/**
 * Functions and variables
 */

// this function has a block body

fun max (a: Int, b: Int): Int{
    return if (a > b) a else b
}

// this function has an expression body

fun max2 (a: Int, b: Int): Int = if (a > b) a else b

// return type also can be omitted (only for fun with an expression body)

fun max3 (a: Int, b: Int) = if (a > b) a else b

/**
 * Two keywords to declare a variable - val and var
 *
 * val stands for value
 * immutable reference, a variable declared with val can't be reassigned after
 * initialization. It corresponds to a final variable in Java.
 *
 * var stands for variable
 * mutable reference, the value of var can be changed.
 * It corresponds to a regular (non-final) Java variable
 */

/**
 * Enum class
 */

/**
 * when expression
 */

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth (color: Color) = when (color){
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix (c1: Color, c2: Color) =
    when (setOf<Color>(c1,c2)){
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception ("Dirty color")
    }

fun mixOptimized (c1: Color, c2: Color) =
    when{
        (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) ->
            Color.ORANGE

        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c1 == Color.BLUE && c2 == Color.YELLOW) ->
            Color.GREEN

        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) ->
            Color.INDIGO

        else -> throw Exception("Dirty color")
    }

/**
 * Smart cast
 */

interface Expr
class Num(val value: Int): Expr
class Sum (val left: Expr, val right: Expr): Expr

fun eval (e: Expr): Int{
    if (e is Num){
        return e.value
    }
    if (e is Sum){
        return eval (e.right) + eval (e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

// keyword is for check a certain type

// keywords as for an explicit cast

fun eval2 (e: Expr): Int =
    if (e is Num){
        e.value
    } else if (e is Sum){
        eval2 (e.right) + eval2(e.left)
    } else{
        throw IllegalArgumentException ("Unknown expression")
    }

fun eval3 (e: Expr): Int =
    when (e) {
        is Num -> {
            e.value
        }

        is Sum -> {
            eval3 (e.right) + eval3(e.left)
        }

        else -> {
            throw IllegalArgumentException ("Unknown expression")
        }
    }

fun evalWithLogging (e: Expr): Int =
    when (e){
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

// the last expression in a block is the result

/**
 * For, while and do-while loops
 */

// ranges - .. operator
// val oneToTen = 1..10

// ranges are closed or inclusive (meaning the second value is always a part of the range)

fun fizzBuzz (i: Int) = when{
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit (c: Char) = c !in '0'..'9'

fun recognize (c: Char) = when (c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}

/**
 * Exceptions in Kotlin
 */

fun readNumber(reader: BufferedReader): Int?{
    try{
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException){
        return null
    }
    finally {
        reader.close()
    }
}

// Kotlin doesn't differentiate between checked and unchecked exceptions

// try as an expression

fun readNumber2 (reader: BufferedReader){
    val number = try{
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        null
    }

    println(number)
}








