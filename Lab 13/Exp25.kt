import kotlin.math.abs

// ---------- (1) Hello World ----------
fun helloKotlin() {
    println("Hello Kotlin!!!")
}

// ---------- (2) Employee Bonus using when ----------
fun calculateBonus(deptCode: String, years: Int, salary: Double): Double {
    // Decide the bonus percentage with a when expression
    val percent = when {
        deptCode == "IT" && years > 5 -> 20
        deptCode == "HR" && years > 3 -> 15
        deptCode == "FIN" && years > 4 -> 12
        else -> 10
    }
    println("  Bonus rate: $percent%")
    return salary * percent / 100
}

// ---------- (3) Average of digits ----------
fun digitAverage(number: Int): Double {
    val n = abs(number)                        // ignore minus sign
    val digits = n.toString().map { it.digitToInt() }
    return digits.sum().toDouble() / digits.size
}

fun main() {
    // Task 1
    println("===== Task 1: Hello =====")
    helloKotlin()

    // Task 2
    println("\n===== Task 2: Employee Bonus =====")
    val employees = listOf(
        Triple("IT", 7, 50000.0),
        Triple("HR", 4, 40000.0),
        Triple("FIN", 2, 30000.0),
        Triple("IT", 3, 60000.0)
    )
    for ((dept, years, salary) in employees) {
        println("Dept: $dept, Experience: $years yrs, Salary: $salary")
        val bonus = calculateBonus(dept, years, salary)
        println("  Bonus amount: %.2f".format(bonus))
    }

    // Task 3
    println("\n===== Task 3: Digit Average =====")
    print("Enter an integer: ")
    val number = readln().trim().toInt()
    println("Average of digits of $number = ${digitAverage(number)}")
}