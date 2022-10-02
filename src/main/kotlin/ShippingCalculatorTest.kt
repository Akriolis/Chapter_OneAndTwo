fun shippingCost(amount: Double, international: Boolean): Double {
    var shipping = 0.0

    if (amount >= 75 && !international) {
        return shipping
    } else if (amount < 75 && !international) {
        shipping = (amount * 0.1).toDouble()
        return shipping
    } else if (international) {
        shipping = (amount * 0.15).toDouble()
        if (shipping > 50.0) {
            return 50.0
        }
    } else {
        return shipping
    }
    return shipping
}
fun main(args: Array<String>) {
    val total = readLine()!!.toDouble()
    val international = readLine()!!.toBoolean()
    println(shippingCost(total, international))

}

