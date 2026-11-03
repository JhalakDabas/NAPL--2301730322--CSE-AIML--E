package main

import "fmt"

// hasNoDivisor checks recursively whether n has any divisor
// from d up to sqrt(n). Returns true if no divisor is found.
func hasNoDivisor(n, d int) bool {
	if d*d > n {
		return true // checked all possible divisors
	}
	if n%d == 0 {
		return false // found a divisor, so not prime
	}
	return hasNoDivisor(n, d+1) // try the next divisor
}

// isPrime returns true if n is a prime number
func isPrime(n int) bool {
	if n < 2 {
		return false
	}
	return hasNoDivisor(n, 2)
}

func main() {
	// Test with several inputs
	tests := []int{1, 2, 7, 10, 13, 25, 97, 100}

	for _, n := range tests {
		if isPrime(n) {
			fmt.Printf("%d is prime\n", n)
		} else {
			fmt.Printf("%d is not prime\n", n)
		}
	}
}