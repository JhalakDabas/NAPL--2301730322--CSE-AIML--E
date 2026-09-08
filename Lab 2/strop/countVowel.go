package strop

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func CountVowels(s string) int {
	count := 0
	for _, char := range s {
		switch char {
		case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
			count++
		}
	}
	return count
}

func ReadUserInput() string {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter a string: ")
	input, _ := reader.ReadString('\n')
	return strings.TrimSpace(input)
}

func CountVowelsFromUserInput() int {
	return CountVowels(ReadUserInput())
}
