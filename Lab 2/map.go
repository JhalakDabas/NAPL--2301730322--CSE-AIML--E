package main

import "fmt"

func printMap(label string, m map[string]int) {
	fmt.Printf("%-32s %v\n", label+":", m)
}

func lookupSubject(m map[string]int, subject string) {
	if marks, ok := m[subject]; ok {
		fmt.Printf("  lookup(%q) -> found, marks = %d\n", subject, marks)
	} else {
		fmt.Printf("  lookup(%q) -> not found\n", subject)
	}
}

func main() {
	marks := map[string]int{"Math": 90, "Science": 85, "English": 78}
	printMap("Initial map", marks)

	marks["History"] = 88
	printMap(`After insert("History", 88)`, marks)

	delete(marks, "English")
	printMap(`After delete("English")`, marks)

	fmt.Println("Lookups:")
	lookupSubject(marks, "Science")
	lookupSubject(marks, "Geography")

	printMap("Final map state", marks)
}
