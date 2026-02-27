data class Contact(
    val name: String,
    val phone: String,
    val email: String?,
    val isFavorite: Boolean
)

fun printContacts(contacts: List<Contact>) {
    for (c in contacts) {
        println("Name  : ${c.name}")
        println("Phone : ${c.phone}")
        if (c.email != null) {
            println("Email : ${c.email}")
        }
        println("Favorite : ${c.isFavorite}")
        println("--------------------------------")
    }
}

fun main() {
    val contacts = listOf(
        Contact("Bhargav Sawant", "+91 98765 43210", "bhargav@gmail.com", true),
        Contact("Priya Sharma", "+91 87654 32109", null, false),
        Contact("Rahul Patel", "+91 76543 21098", "rahul@work.com", true),
        Contact("Sneha Rao", "+91 65432 10987", "sneha@gmail.com", false)
    )

    println("ALL CONTACTS")
    printContacts(contacts)

    val favorites = contacts.filter { it.isFavorite }
    println("\nFAVORITE CONTACTS")
    printContacts(favorites)

    val withEmail = contacts.filter { it.email != null }
    println("\nCONTACTS WITH EMAIL")
    printContacts(withEmail)
}