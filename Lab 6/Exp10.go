package main

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
	"unicode"
)

// ---------- Task 1: Reverse and Palindrome ----------

// reverse returns the string written backwards
func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

// isPalindrome ignores upper/lower case
func isPalindrome(s string) bool {
	s = strings.ToLower(s)
	return s == reverse(s)
}

// ---------- Task 2: Transform ----------

// transform: all letters -> uppercase, all digits -> number doubled,
// otherwise -> unchanged
func transform(s string) string {
	if s == "" {
		return s
	}

	allLetters := true
	allDigits := true

	for _, ch := range s {
		if !unicode.IsLetter(ch) {
			allLetters = false
		}
		if !unicode.IsDigit(ch) {
			allDigits = false
		}
	}

	switch {
	case allLetters:
		return strings.ToUpper(s)
	case allDigits:
		num, _ := strconv.Atoi(s)
		return strconv.Itoa(num * 2)
	default:
		return s
	}
}

// ---------- Task 3: Email Validation ----------

var emailPattern = regexp.MustCompile(`^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$`)

func isValidEmail(email string) bool {
	return emailPattern.MatchString(email)
}

func main() {
	// Task 1 tests
	fmt.Println("--- Reverse and Palindrome ---")
	for _, s := range []string{"madam", "hello", "Level"} {
		fmt.Printf("%q reversed = %q, palindrome = %v\n", s, reverse(s), isPalindrome(s))
	}

	// Task 2 tests
	fmt.Println("\n--- Transform ---")
	for _, s := range []string{"hello", "123", "abc123"} {
		fmt.Printf("%q -> %q\n", s, transform(s))
	}

	// Task 3 tests
	fmt.Println("\n--- Email Validation ---")
	for _, e := range []string{"user@example.com", "bad.email@", "john_doe@mail.co.in"} {
		fmt.Printf("%q valid = %v\n", e, isValidEmail(e))
	}
}