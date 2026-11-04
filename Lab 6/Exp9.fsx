open System

// Read one mark from the user
let readMark (n: int) : float =
    printf "Enter marks for subject %d: " n
    Console.ReadLine() |> float

// Pattern matching with guards to decide the division
let classify (percentage: float) : string =
    match percentage with
    | p when p >= 60.0 -> "First Division"
    | p when p >= 50.0 -> "Second Division"
    | p when p >= 40.0 -> "Third Division"
    | _ -> "Fail"

let marks = [ for i in 1 .. 4 -> readMark i ]
let total = List.sum marks
let percentage = total / 4.0   // 4 subjects, each out of 100

printfn "Total: %.2f" total
printfn "Percentage: %.2f%%" percentage
printfn "Result: %s" (classify percentage)