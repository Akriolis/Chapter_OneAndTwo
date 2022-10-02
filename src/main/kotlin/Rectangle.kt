import java.util.Random

class Rectangle (private val height: Int, private val weight: Int){
    val isSquare: Boolean
        get() = height == weight

    fun createRandomRectangle(): Rectangle{
        val random = Random()
        return Rectangle(random.nextInt(1,100), random.nextInt(1,100))
    }


}