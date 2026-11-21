class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    // Accept / update data from user input (public)
    fun acceptData() {
        print("Enter roll number : ")
        rollNo = readln().trim().toInt()
        print("Enter name        : ")
        name = readln().trim()
        print("Enter course      : ")
        course = readln().trim()
        print("Enter percentage  : ")
        percentage = readln().trim().toDouble()
    }

    // Display all details in a formatted way (public)
    fun display() {
        println("---------------------------")
        println("Roll No    : $rollNo")
        println("Name       : $name")
        println("Course     : $course")
        println("Percentage : %.2f%%".format(percentage))
        println("---------------------------")
    }
}

fun main() {
    // Create two Student objects using the primary constructor
    val s1 = Student(0, "", "", 0.0)
    val s2 = Student(0, "", "", 0.0)

    println("Enter details of Student 1:")
    s1.acceptData()
    println("\nDetails of Student 1:")
    s1.display()

    println("\nEnter details of Student 2:")
    s2.acceptData()
    println("\nDetails of Student 2:")
    s2.display()
}