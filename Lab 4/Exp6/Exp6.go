package main

import (
	"fmt"
	"sync"
)

func computeSquares(n int, ch chan<- string, wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Println("Squares goroutine: started")
	result := "Squares: "
	for i := 1; i <= n; i++ {
		result += fmt.Sprintf("%d ", i*i)
	}
	fmt.Println("Squares goroutine: completed")
	ch <- result
}

func computeCubes(n int, ch chan<- string, wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Println("Cubes goroutine: started")
	result := "Cubes: "
	for i := 1; i <= n; i++ {
		result += fmt.Sprintf("%d ", i*i*i)
	}
	fmt.Println("Cubes goroutine: completed")
	ch <- result
}

func computeFibonacci(n int, ch chan<- string, wg *sync.WaitGroup) {
	defer wg.Done()
	fmt.Println("Fibonacci goroutine: started")
	fibs := make([]int, n)
	for i := range fibs {
		if i <= 1 {
			fibs[i] = i
		} else {
			fibs[i] = fibs[i-1] + fibs[i-2]
		}
	}
	result := "Fibonacci: "
	for _, f := range fibs {
		result += fmt.Sprintf("%d ", f)
	}
	fmt.Println("Fibonacci goroutine: completed")
	ch <- result
}

func main() {
	n := 10
	ch := make(chan string, 3)

	var wg sync.WaitGroup
	wg.Add(3)

	go computeSquares(n, ch, &wg)
	go computeCubes(n, ch, &wg)
	go computeFibonacci(n, ch, &wg)

	wg.Wait()
	close(ch)

	fmt.Println("\n---- Results ----")
	for result := range ch {
		fmt.Println(result)
	}
}