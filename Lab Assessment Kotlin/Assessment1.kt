// 1. Domain model (null-safe: email can be null)
class Student(val name: String, val email: String?, val marks: Int)

// 3. Extension functions
fun Student.isPassed(): Boolean = marks >= 50
fun Student.showEmail(): String = email ?: "No email"

// 4. Simple DSL
class Report {
    fun line(text: String) = println("  - $text")
}
fun report(title: String, block: Report.() -> Unit) {
    println("== $title ==")
    Report().block()
}

fun main() {
    val students = listOf(
        Student("Ali", "ali@mail.com", 85),
        Student("Sara", null, 40),
        Student("Omar", "omar@mail.com", 70),
        Student("Lina", null, 90)
    )

    // 2. Collections
    val names = students.map { it.name }
    val passed = students.filter { it.isPassed() }
    val total = students.map { it.marks }.reduce { a, b -> a + b }
    val groups = students.groupBy { it.isPassed() }

    println("Names: $names")
    println("Total marks: $total")

    report("Student Report") {
        line("Passed: ${passed.size}")
        line("Failed: ${groups[false]?.size ?: 0}")
        for (s in students) line("${s.name} - ${s.marks} - ${s.showEmail()}")
    }
}