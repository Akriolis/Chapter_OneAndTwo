import java.lang.Exception

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
