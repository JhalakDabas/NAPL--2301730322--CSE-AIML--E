let list1 = [ 1; 2; 3; 4; 5 ]
let list2 = [ 10; 15; 20; 25; 30; 35 ]

// ---------- (1) List.map: square each number ----------
printfn "--- List.map (square) ---"
printfn "%A -> %A" list1 (List.map (fun x -> x * x) list1)
printfn "%A -> %A" list2 (List.map (fun x -> x * x) list2)

// ---------- (2) List.filter: keep only even numbers ----------
printfn "\n--- List.filter (even only) ---"
printfn "%A -> %A" list1 (List.filter (fun x -> x % 2 = 0) list1)
printfn "%A -> %A" list2 (List.filter (fun x -> x % 2 = 0) list2)

// ---------- (3) List.fold / List.reduce: sum, product, maximum ----------
printfn "\n--- List.fold (sum) ---"
printfn "%A -> sum = %d" list1 (List.fold (fun acc x -> acc + x) 0 list1)
printfn "%A -> sum = %d" list2 (List.fold (fun acc x -> acc + x) 0 list2)

printfn "\n--- List.fold (product) ---"
printfn "%A -> product = %d" list1 (List.fold (fun acc x -> acc * x) 1 list1)
printfn "%A -> product = %d" list2 (List.fold (fun acc x -> acc * x) 1 list2)

printfn "\n--- List.reduce (maximum) ---"
printfn "%A -> max = %d" list1 (List.reduce (fun a b -> if a > b then a else b) list1)
printfn "%A -> max = %d" list2 (List.reduce (fun a b -> if a > b then a else b) list2)