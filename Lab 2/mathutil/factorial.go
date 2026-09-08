package mathutil

import "fmt"

func Factorial(n int) int {
	if n <= 1 {
		return 1
	}
	return n * Factorial(n-1)
}

func InputFactorial() int {
	var n int
	fmt.Print("Enter a number: ")
	fmt.Scan(&n)
	return Factorial(n)
}
