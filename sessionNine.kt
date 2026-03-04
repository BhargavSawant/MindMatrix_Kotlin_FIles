// TODO: Define data class Item(name: String, category: String, quantity: Int)
data class Item(val name: String, val category: String, val quantity: Int)

// TODO: Implement printInventory(items: List<Item>)
fun printInventory(items: List<Item>) {
    for (item in items) {
        println("Name: ${item.name} | Category: ${item.category} | Qty: ${item.quantity}")
    }
}

// TODO: Implement generic filterList(list: List<T>, condition: (T) -> Boolean): List<T>
fun <T> filterList(list: List<T>, condition: (T) -> Boolean): List<T> {
    return list.filter(condition)
}

// TODO: Implement main() — create sample items, call filterList() & print results
fun main() {
    val sampleItems = listOf(
        Item("Laptop", "Electronics", 12),
        Item("Keyboard", "Electronics", 5),
        Item("Chair", "Furniture", 20),
        Item("Table", "Furniture", 8),
        Item("Notebook", "Stationery", 50)
    )

    // Full inventory
    println("--- Full Inventory ---")
    printInventory(sampleItems)
    println()

    // Low stock filter
    val lowStock = filterList(sampleItems) { it.quantity < 10 }
    println("--- Low Stock (<10) ---")
    printInventory(lowStock)
    println()

    // Electronics category filter
    val electronics = filterList(sampleItems) { it.category == "Electronics" }
    println("--- Electronics Category ---")
    printInventory(electronics)
    println()

    // Bonus: Category totals (using fold for compatibility with older Kotlin)
    val categoryTotals = sampleItems.groupBy { it.category }.mapValues { entry ->
        entry.value.fold(0) { acc, item -> acc + item.quantity }
    }
    println("--- Total Quantity per Category ---")
    for ((category, total) in categoryTotals) {
        println("$category: $total")
    }
}