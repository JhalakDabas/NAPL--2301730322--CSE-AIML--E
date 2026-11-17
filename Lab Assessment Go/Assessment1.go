package main

import (
	"errors"
	"fmt"
)

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

func main() {
//  Q1
	items := []Item{}
	items = append(items, Item{1, "Television", 2, 1000})
	items = append(items, Item{2, "Printer", 10, 25})
	fmt.Println(items)
	fmt.Println("Total items:", len(items))

// Q2
	newItem := Item{3, "Speaker", 5, 50}
	if newItem.Name == "" || newItem.Quantity < 0 || newItem.Price < 0 {
		fmt.Println("Add error:", errors.New("invalid item"))
	} else {
		items = append(items, newItem)
		fmt.Println("After Add:", items)
	}

	// Update ID 1
	for i, v := range items {
		if v.ID == 1 {
			items[i].Name = "LED Television"
			items[i].Price = 1200
		}
	}
	fmt.Println("After Update:", items)

	// Remove ID 2
	for i, v := range items {
		if v.ID == 2 {
			items = append(items[:i], items[i+1:]...)
			break
		}
	}
	fmt.Println("After Remove:", items)

	// Adding wrong item
	bad := Item{4, "", -1, -10}
	if bad.Name == "" {
		fmt.Println("Add error: name cannot be empty")
	}

	// Q3
	ch := make(chan float64)

	go func() {
		total := 0.0
		for _, v := range items {
			total += float64(v.Quantity) * v.Price
		}
		ch <- total
	}()

	totalValue := <-ch
	fmt.Println("Item Count:", len(items))
	fmt.Println("Total Value:", totalValue)
}




































