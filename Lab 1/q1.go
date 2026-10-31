package main

import "fmt"

func main() {
	// Task 1: verify Go is installed and working by running a simple program.
	fmt.Println("Go is installed and working!")

	// Task 2: declare two integers and two floats, then do
	// addition, subtraction, and multiplication on each pair.

	// Integer variables
	var a int = 10
	var b int = 4

	// Float variables
	var x float64 = 10.5
	var y float64 = 4.2

	// Integer arithmetic
	intSum := a + b
	intDiff := a - b
	intProduct := a * b

	// Float arithmetic
	floatSum := x + y
	floatDiff := x - y
	floatProduct := x * y

	fmt.Println("\n---- Integer Arithmetic ----")
	fmt.Println("a =", a, ", b =", b)
	fmt.Println("Addition:", intSum)
	fmt.Println("Subtraction:", intDiff)
	fmt.Println("Multiplication:", intProduct)

	fmt.Println("\n---- Float Arithmetic ----")
	fmt.Println("x =", x, ", y =", y)
	fmt.Println("Addition:", floatSum)
	fmt.Println("Subtraction:", floatDiff)
	fmt.Println("Multiplication:", floatProduct)
}