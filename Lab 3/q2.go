package main

import "fmt"

type Student struct {
	Name string
	Age  int
}

func modifyVariable(ptr *int) {
	*ptr = *ptr + 10
}

func addDataInStructure(s *Student) {
	s.Name = "Rahul"
	s.Age = 21
}

func main() {
	num := 10

	ptr := &num

	fmt.Println("Address of num:", ptr)

	fmt.Println("Value of num using pointer:", *ptr)

	fmt.Println("Value of num before modification:", num)

	modifyVariable(&num)

	fmt.Println("Value of num after modification:", num)

	s1 := new(Student)

	addDataInStructure(s1)

	fmt.Println("Student data:", *s1)
}