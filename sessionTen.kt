// TODO 1: Define a Product class with:
// - name (String)
// - category (String)
// - price (Double)
// - stock (Int)
data class Product(val name: String, val category: String, var price: Double, val stock: Int)

// TODO 2: Create a higher-order function called `applyDiscount`
// that takes:
// - a list of products
// - a discount function: (Double) -> Double
// It should return a **new list** of products with the discounted price applied.
// Hint: Use `map()` to transform the list.
fun applyDiscount(products: List<Product>, discount: (Double) -> Double): List<Product> {
    return products.map { product ->
        product.copy(price = discount(product.price))
    }
}

// TODO 3: Create a higher-order function called `filterProducts`
// that takes:
// - a list of products
// - a condition function: (Product) -> Boolean
// It should return a **filtered list** based on the condition.
fun <T : Product> filterProducts(products: List<T>, condition: (T) -> Boolean): List<T> {
    return products.filter(condition)
}

// TODO 4: In `main()`:
// 1. Create a sample product list (at least 5 products).
// 2. Use `applyDiscount` to reduce all prices by 10%.
// 3. Use `filterProducts` to find:
// a) Products with stock less than 10
// b) Products with price greater than 1000
// 4. Print results using clear, formatted output.
// Hint: Use string templates and loops.
fun main() {
    // TODO 5: Implement your logic here
    val products = listOf(
        Product("Laptop", "Electronics", 100000.0, 5),
        Product("Phone", "Electronics", 50000.0, 15),
        Product("Chair", "Furniture", 2000.0, 25),
        Product("Table", "Furniture", 3000.0, 5),
        Product("Pen", "Stationery", 50.0, 100)
    )

    // Apply 10% discount
    val discountedProducts = applyDiscount(products) { price -> price * 0.9 }

    // Print discounted list
    println("--- Discounted Product List ---")
    for (product in discountedProducts) {
        println("Name: ${product.name} | Category: ${product.category} | Price: ${product.price} | Stock: ${product.stock}")
    }
    println()

    // Low stock filter
    val lowStock = filterProducts(discountedProducts) { it.stock < 10 }
    println("--- Low Stock Products (<10) ---")
    for (product in lowStock) {
        println("${product.name} (${product.stock})")
    }
    println()

    // Premium filter
    val premium = filterProducts(discountedProducts) { it.price > 1000 }
    println("--- Premium Products (>1000) ---")
    for (product in premium) {
        println("${product.name} (${product.price})")
    }
}