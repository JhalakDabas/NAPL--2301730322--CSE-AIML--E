let isPrime (n: int) : bool =
    
    let rec hasNoDivisor d =
        if d * d > n then true          // no divisor found, so prime
        elif n % d = 0 then false       // found a divisor, so not prime
        else hasNoDivisor (d + 1)       // try the next divisor
    n >= 2 && hasNoDivisor 2

[ 1; 2; 7; 10; 13; 25; 97; 100 ]
|> List.iter (fun n ->
    if isPrime n then printfn "%d is prime" n
    else printfn "%d is not prime" n)