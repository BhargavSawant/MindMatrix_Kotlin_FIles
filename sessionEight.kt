data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)

fun main() {
    val artworks = listOf(
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("The Scream", "Edvard Munch", 1893),
        Artwork("Guernica", "Pablo Picasso", 1937)
    )

    println("Art Gallery")

    for (art in artworks) {
        println("\n${art.title} by ${art.artist} (${art.year})")
    }
}