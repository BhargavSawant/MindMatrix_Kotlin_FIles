import kotlin.random.Random

fun rollDie(sides: Int, rnd: Random): Int {
    return rnd.nextInt(1, sides + 1)
}

fun rollTwoDice(rnd: Random): Pair<Int, Int> {
    val die1 = rollDie(6, rnd)
    val die2 = rollDie(6, rnd)
    return Pair(die1, die2)
}

fun formatRoll(rollNumber: Int, a: Int, b: Int): String {
    var result = "Roll $rollNumber: $a and $b"
    if (a == b) {
        result += " <Double!>"
    }
    return result
}

fun main() {
    val rnd = Random(123)
    var rollNumber = 0

    println("Dice Roller ...")

    repeat(3) {
        println("Pressing \"Roll\" ...")
        val (die1, die2) = rollTwoDice(rnd)
        rollNumber++
        println(formatRoll(rollNumber, die1, die2))
    }
}