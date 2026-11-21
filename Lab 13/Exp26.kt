// ---------- (1) Default parameters ----------
fun greet(name: String = "Guest", greeting: String = "Hello", punctuation: String = "!") {
    println("$greeting, $name$punctuation")
}

// ---------- (3) vararg ----------
fun printAll(vararg numbers: Int) {
    if (numbers.isEmpty()) {
        println("Numbers: (none)")
        return
    }
    print("Numbers:")
    for (n in numbers) {
        print(" $n")
    }
    println()
}

// ---------- (4) Higher-order function ----------
fun applyToList(list: List<Int>, operation: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in list) {
        result.add(operation(item))
    }
    return result
}

fun main() {
    // (1) Default parameters: with and without values
    println("===== (1) Default parameters =====")
    greet()                                  // all defaults
    greet("Asha")                            // greeting and punctuation default
    greet("Asha", "Welcome")                 // punctuation default
    greet("Asha", "Good morning", "!!!")     // no defaults used

    // (2) Named arguments, out of order
    println("\n===== (2) Named arguments =====")
    greet(punctuation = "?", name = "Ravi", greeting = "Hi")
    greet(greeting = "Namaste", name = "Meena")

    // (3) vararg
    println("\n===== (3) vararg =====")
    printAll(1, 2, 3)
    printAll(10, 20, 30, 40, 50)
    printAll()
    val arr = intArrayOf(7, 8, 9)
    printAll(*arr)                           // * spreads an array into vararg

    // (4) Higher-order function with lambdas
    println("\n===== (4) Higher-order function =====")
    val nums = listOf(1, 2, 3, 4, 5)
    println("Original      : $nums")
    println("Squared       : ${applyToList(nums) { x -> x * x }}")
    println("Doubled       : ${applyToList(nums) { it * 2 }}")
    println("Plus 10       : ${applyToList(nums) { it + 10 }}")
}