package main

import "testing"

func TestDivide(t *testing.T) {
	result, err := Divide(10, 2)
	if err != nil {
		t.Errorf("unexpected error: %v", err)
	}
	if result != 5 {
		t.Errorf("expected 5, got %v", result)
	}

	_, err = Divide(10, 0)
	if err == nil {
		t.Error("expected an error for division by zero, got nil")
	}
}

func TestSquareRoot(t *testing.T) {
	result, err := SquareRoot(16)
	if err != nil {
		t.Errorf("unexpected error: %v", err)
	}
	if result != 4 {
		t.Errorf("expected 4, got %v", result)
	}

	_, err = SquareRoot(-4)
	if err == nil {
		t.Error("expected an error for negative square root, got nil")
	}
}

func TestValidateInput(t *testing.T) {
	result, err := ValidateInput("  hello  ")
	if err != nil {
		t.Errorf("unexpected error: %v", err)
	}
	if result != "hello" {
		t.Errorf("expected %q, got %q", "hello", result)
	}

	_, err = ValidateInput("   ")
	if err == nil {
		t.Error("expected an error for empty input, got nil")
	}
}