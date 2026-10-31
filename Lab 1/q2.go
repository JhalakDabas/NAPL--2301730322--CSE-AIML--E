package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var reader = bufio.NewReader(os.Stdin)

func readInt(prompt string, min int, max int) int {
	for {
		fmt.Print(prompt)
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)

		n, err := strconv.Atoi(line)
		if err != nil {
			fmt.Println("That's not a valid whole number. Try again.")
			continue
		}

		if n < min || n > max {
			fmt.Printf("Please enter a number between %d and %d.\n", min, max)
			continue
		}

		return n
	}
}

func readFloat(prompt string, min float64, max float64) float64 {
	for {
		fmt.Print(prompt)
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)

		n, err := strconv.ParseFloat(line, 64)
		if err != nil {
			fmt.Println("That's not a valid number. Try again.")
			continue
		}

		if n < min || n > max {
			fmt.Printf("Please enter a number between %.2f and %.2f.\n", min, max)
			continue
		}

		return n
	}
}

func main() {
	fmt.Println("---- Integer Calculator ----")
	a := readInt("Enter first whole number (1-1000): ", 1, 1000)
	b := readInt("Enter second whole number (1-1000): ", 1, 1000)

	fmt.Println("\nResults:")
	fmt.Println("Addition:", a+b)
	fmt.Println("Subtraction:", a-b)
	fmt.Println("Multiplication:", a*b)

	fmt.Println("\n---- Float Calculator ----")
	x := readFloat("Enter first decimal number (1-1000): ", 1, 1000)
	y := readFloat("Enter second decimal number (1-1000): ", 1, 1000)

	fmt.Println("\nResults:")
	fmt.Println("Addition:", x+y)
	fmt.Println("Subtraction:", x-y)
	fmt.Println("Multiplication:", x*y)
}