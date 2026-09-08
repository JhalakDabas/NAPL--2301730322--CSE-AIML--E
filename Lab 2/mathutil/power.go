package mathutil

import "fmt"

func Power(base, exponent int) int {
	result := 1
	for i := 0; i < exponent; i++ {
		result *= base
	}
	return result
}

func PowerInput() int {
	var base, exponent int
	fmt.Print("Enter base: ")
	fmt.Scan(&base)
	fmt.Print("Enter exponent: ")
	fmt.Scan(&exponent)
	return Power(base, exponent)
}
