// 🦁 Zoo Animal Tracker — Student Task Template
// Goal: Practice OOP concepts like inheritance, abstract classes, and interfaces in Kotlin.

abstract class Animal(val name: String) {
    abstract fun makeSound()
}

class Lion(name: String) : Animal(name), Feedable {
    override fun makeSound() {
        println("$name: Roar!")
    }
    fun hunt() {
        println("$name hunts for prey.")
    }
    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

class Elephant(name: String) : Animal(name), Feedable {
    override fun makeSound() {
        println("$name: Trumpet!")
    }
    fun sprayWater() {
        println("$name sprays water from trunk.")
    }
    override fun feed(food: String) {
        println("$name eats $food.")
    }
}

class Parrot(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name: Chirp!")
    }
    fun mimic(word: String) {
        println("$name mimics: $word")
    }
}

interface Feedable {
    fun feed(food: String)
}

fun displayZoo(animals: List<Animal>) {
    println("--- Zoo Tracker ---")
    for (animal in animals) {
        animal.makeSound()
    }
}

fun main() {
    val zooAnimals = listOf(
        Lion("Simba"),
        Elephant("Dumbo"),
        Parrot("Polly"),
        Lion("Mufasa")
    )

    displayZoo(zooAnimals)

    // Extra behaviors (polymorphism demonstration)
    val simba = zooAnimals[0] as Lion
    simba.hunt()
    simba.feed("meat")

    val dumbo = zooAnimals[1] as Elephant
    dumbo.sprayWater()
    dumbo.feed("hay")

    val polly = zooAnimals[2] as Parrot
    polly.mimic("Hello!")

    // Feed via interface
    if (zooAnimals[0] is Feedable) (zooAnimals[0] as Feedable).feed("zebra")
    if (zooAnimals[1] is Feedable) (zooAnimals[1] as Feedable).feed("leaves")
}