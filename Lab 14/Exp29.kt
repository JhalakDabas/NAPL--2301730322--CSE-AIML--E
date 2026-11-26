// Simple data class for part (3)
data class Student(val name: String, val course: String, val percentage: Double)

fun main() {
    // ---------- (1) Read-only and mutable List, Set, Map ----------
    println("===== (1) LIST =====")
    val readOnlyList = listOf(10, 20, 30)               // read-only: no add/remove
    val mutableList = mutableListOf(10, 20, 30)         // mutable
    mutableList.add(40)
    mutableList.remove(10)
    println("Read-only list : $readOnlyList")
    println("Mutable list   : $mutableList")
    println("contains 20    : ${mutableList.contains(20)}")
    println("get index 1    : ${mutableList[1]}")
    // readOnlyList.add(5)   // ERROR: no add() on a read-only List

    println("\n===== (1) SET =====")
    val readOnlySet = setOf(1, 2, 3, 3, 2)              // duplicates ignored
    val mutableSet = mutableSetOf(1, 2, 3)
    mutableSet.add(4)
    mutableSet.add(2)                                    // already present, ignored
    mutableSet.remove(1)
    println("Read-only set  : $readOnlySet")
    println("Mutable set    : $mutableSet")
    println("contains 3     : ${mutableSet.contains(3)}")

    println("\n===== (1) MAP =====")
    val readOnlyMap = mapOf("Asha" to 20, "Ravi" to 21)
    val mutableMap = mutableMapOf("Asha" to 20, "Ravi" to 21)
    mutableMap["Meena"] = 22                             // add
    mutableMap.remove("Ravi")                            // remove
    println("Read-only map  : $readOnlyMap")
    println("Mutable map    : $mutableMap")
    println("get \"Asha\"      : ${mutableMap["Asha"]}")
    println("containsKey    : ${mutableMap.containsKey("Meena")}")

    // ---------- (2) map, filter, reduce step by step ----------
    println("\n===== (2) map / filter / reduce (integers) =====")
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Original        : $numbers")

    val squared = numbers.map { it * it }
    println("After map (x*x) : $squared")

    val evens = squared.filter { it % 2 == 0 }
    println("After filter    : $evens")

    val sum = evens.reduce { acc, x -> acc + x }
    println("After reduce(+) : $sum")

    println("\n===== (2) map / filter / reduce (strings) =====")
    val words = listOf("kotlin", "java", "go", "clojure", "fsharp")
    println("Original        : $words")

    val upper = words.map { it.uppercase() }
    println("After map       : $upper")

    val longWords = upper.filter { it.length > 4 }
    println("After filter    : $longWords")

    val joined = longWords.reduce { acc, w -> "$acc-$w" }
    println("After reduce    : $joined")

    // ---------- (3) sortedBy and groupBy on objects ----------
    println("\n===== (3) Sort students by percentage =====")
    val students = listOf(
        Student("Asha", "CSE", 85.5),
        Student("Ravi", "IT", 72.0),
        Student("Meena", "CSE", 91.25),
        Student("Karan", "IT", 66.5),
        Student("Divya", "ECE", 78.0)
    )

    println("Ascending:")
    for (s in students.sortedBy { it.percentage }) {
        println("  ${s.name} (${s.course}) - ${s.percentage}")
    }

    println("Descending:")
    for (s in students.sortedByDescending { it.percentage }) {
        println("  ${s.name} (${s.course}) - ${s.percentage}")
    }

    println("\n===== (3) groupBy course =====")
    val byCourse = students.groupBy { it.course }
    for ((course, list) in byCourse) {
        println("$course -> ${list.map { it.name }}")
    }
}