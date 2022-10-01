fun main() {
    var hours = readLine()!!.toInt()
    var total: Double = 0.0

    var firstFive = hours * 1
    var between5And24 = (hours-5) * 0.5
    var moreThan24 = 15
    var day = (hours / 24).toInt()

    total =
        if (hours <= 5){
        firstFive.toDouble()
    } else if (hours in 5..24){
        var myResult = between5And24.toDouble()
        5.0 + myResult
    } else{
        ((day * moreThan24) + (hours % 24) * 0.5).toDouble()
    }

    println(total)
}