package main

import (
	"fmt"

	m "example.com/app/mathutil"
	s "example.com/app/strop"
)

func main() {
	fmt.Println(" Math functions ")

	fact := m.Factorial(5)
	fmt.Println("Factorial(5) =", fact)

	pow := m.Power(2, 3)
	fmt.Println("Power(2, 3) =", pow)

	fmt.Println("\nString functions")

	reversed := s.Reverse("hello")
	fmt.Println(`Reverse("hello") =`, reversed)

	vowelCount := s.CountVowels("Hello World")
	fmt.Println(`CountVowels("Hello World") =`, vowelCount)
}
