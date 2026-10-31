package main

import (
	"fmt"
	"math"
	"strings"
)

func Divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("division by zero: cannot divide %v by 0", a)
	}
	return a / b, nil
}

func SquareRoot(x float64) (float64, error) {
	if x < 0 {
		return 0, fmt.Errorf("negative square root: cannot take square root of %v", x)
	}
	return math.Sqrt(x), nil
}

func ValidateInput(s string) (string, error) {
	trimmed := strings.TrimSpace(s)
	if trimmed == "" {
		return "", fmt.Errorf("empty input: input string cannot be empty")
	}
	return trimmed, nil
}

func main() {
	if result, err := Divide(10, 2); err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("10 / 2 =", result)
	}
	if _, err := Divide(10, 0); err != nil {
		fmt.Println("Error:", err)
	}

	if result, err := SquareRoot(16); err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("sqrt(16) =", result)
	}
	if _, err := SquareRoot(-4); err != nil {
		fmt.Println("Error:", err)
	}

	if result, err := ValidateInput("  hello  "); err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Valid input:", result)
	}
	if _, err := ValidateInput("   "); err != nil {
		fmt.Println("Error:", err)
	}
}