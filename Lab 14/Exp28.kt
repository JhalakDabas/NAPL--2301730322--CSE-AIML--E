// A small class to demonstrate safe calls on properties
class Person(val name: String, val email: String?)

fun main() {
    // ---------- (1) Nullable vs non-nullable ----------
    println("===== (1) Nullable vs non-nullable =====")
    var nonNull: String = "Hello"
    var nullable: String? = "World"

    // nonNull = null      // COMPILE ERROR: null cannot be a value of type String
    nullable = null        // OK: String? can hold null

    println("Non-nullable : $nonNull")
    println("Nullable     : $nullable")
    // println(nullable.length)   // COMPILE ERROR: only safe (?.) or non-null asserted (!!.) calls allowed

    // ---------- (2) Safe call operator ?. ----------
    println("\n===== (2) Safe call (?.) =====")
    val name1: String? = "Kotlin"
    val name2: String? = null
    println("name1?.length : ${name1?.length}")          // 6
    println("name2?.length : ${name2?.length}")          // null (no crash)
    println("name1?.uppercase() : ${name1?.uppercase()}")
    println("name2?.uppercase() : ${name2?.uppercase()}")

    val p1 = Person("Asha", "asha@example.com")
    val p2 = Person("Ravi", null)
    println("p1 email length : ${p1.email?.length}")
    println("p2 email length : ${p2.email?.length}")

    // ---------- (3) Elvis operator ?: ----------
    println("\n===== (3) Elvis operator (?:) =====")
    val len1 = name1?.length ?: 0
    val len2 = name2?.length ?: 0
    println("name1 length (default 0)  : $len1")
    println("name2 length (default 0)  : $len2")

    val display = p2.email ?: "No email provided"
    println("p2 email : $display")

    val city: String? = null
    println("City : ${city ?: "Unknown"}")

    // ---------- (4) !! operator with try-catch ----------
    println("\n===== (4) Not-null assertion (!!) =====")
    val safeValue: String? = "I am not null"
    println("Length of safeValue : ${safeValue!!.length}")   // works

    val nullValue: String? = null
    try {
        println("Trying nullValue!!.length ...")
        println(nullValue!!.length)                           // throws
    } catch (e: NullPointerException) {
        println("Caught NullPointerException: ${e.message}")
    }
    println("Program continues normally.")
}