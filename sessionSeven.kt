fun calculateTip(bill: Double, tipPercent: Double, roundUp: Boolean): Double {
    var tip = bill * (tipPercent / 100)
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return tip
}

fun main() {
    val bill = 100.0
    val tipPercent = 15.0
    val roundUp = true

    val tip = calculateTip(bill, tipPercent, roundUp)
    val total = bill + tip

    println("Bill: $$bill")
    println("Tip percent: $tipPercent%")
    println("Round up: $roundUp")
    println("Tip: $${"%.2f".format(tip)}")
    println("Total: $${"%.2f".format(total)}")
}