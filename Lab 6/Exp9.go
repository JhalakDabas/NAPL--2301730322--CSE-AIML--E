package main

import "fmt"

func main() {
	var subjects [4]float64

	// Read marks for four subjects (each out of 100)
	for i := 0; i < 4; i++ {
		fmt.Printf("Enter marks for subject %d: ", i+1)
		fmt.Scan(&subjects[i])
	}

	// Add up all marks
	total := 0.0
	for _, m := range subjects {
		total += m
	}

	// Percentage = total / (4 * 100) * 100 = total / 4
	percentage := total / 4

	// Decide the division (like pattern matching)
	var division string
	switch {
	case percentage >= 60:
		division = "First Division"
	case percentage >= 50:
		division = "Second Division"
	case percentage >= 40:
		division = "Third Division"
	default:
		division = "Fail"
	}

	fmt.Printf("Total: %.2f\n", total)
	fmt.Printf("Percentage: %.2f%%\n", percentage)
	fmt.Println("Result:", division)
}