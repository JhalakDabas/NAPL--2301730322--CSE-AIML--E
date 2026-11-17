package main

import "testing"

func TestAdd(t *testing.T) {
	items := []Item{}
	items = append(items, Item{1, "Television", 1, 100})
	if len(items) != 1 {
		t.Error("Add failed")
	}
}

func TestUpdate(t *testing.T) {
	items := []Item{{1, "Television", 1, 100}}
	items[0].Name = "LED Television"
	if items[0].Name != "LED Television" {
		t.Error("Update failed")
	}
}

func TestRemove(t *testing.T) {
	items := []Item{{1, "Television", 1, 100}}
	items = items[1:]
	if len(items) != 0 {
		t.Error("Remove failed")
	}
}