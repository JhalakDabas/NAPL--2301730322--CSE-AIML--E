package main

import "fmt"

func addStudent(s []string, name string) []string {
	return append(s, name)
}

func removeAtIndex(s []string, index int) []string {
	if index < 0 || index >= len(s) {
		fmt.Printf("  removeAtIndex: index %d is out of range for a slice of length %d\n", index, len(s))
		return s
	}
	return append(s[:index], s[index+1:]...)
}

func updateAtIndex(s []string, index int, value string) []string {
	if index < 0 || index >= len(s) {
		fmt.Printf("  updateAtIndex: index %d is out of range for a slice of length %d\n", index, len(s))
		return s
	}
	s[index] = value
	return s
}

func printSlice(label string, s []string) {
	fmt.Printf("%-32s %v  (len=%d, cap=%d)\n", label+":", s, len(s), cap(s))
}

func main() {
	students := []string{"Alice", "Bob", "Charlie"}
	printSlice("Initial slice", students)

	students = addStudent(students, "Diana")
	printSlice(`After add("Diana")`, students)

	students = removeAtIndex(students, 1)
	printSlice("After removeAtIndex(1)", students)

	students = updateAtIndex(students, 0, "Alicia")
	printSlice(`After updateAtIndex(0, "Alicia")`, students)

	students = removeAtIndex(students, 99)
	students = updateAtIndex(students, -1, "X")
}