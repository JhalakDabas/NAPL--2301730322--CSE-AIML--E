package main

import "fmt"

type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}

func (p *Person) ReadInput() {
	fmt.Print("Enter name: ")
	fmt.Scan(&p.Name)

	fmt.Print("Enter age: ")
	fmt.Scan(&p.Age)

	fmt.Print("Enter job: ")
	fmt.Scan(&p.Job)

	fmt.Print("Enter salary: ")
	fmt.Scan(&p.Salary)
}

func (p Person) Display() {
	fmt.Printf("Name: %s | Age: %d | Job: %s | Salary: %.2f\n", p.Name, p.Age, p.Job, p.Salary)
}

func main() {
	var person1 Person
	fmt.Println("--- Enter details for Person 1 ---")
	person1.ReadInput()

	var person2 Person
	fmt.Println("\n--- Enter details for Person 2 ---")
	person2.ReadInput()

	fmt.Println("\n--- Person Details ---")
	person1.Display()
	person2.Display()
}
