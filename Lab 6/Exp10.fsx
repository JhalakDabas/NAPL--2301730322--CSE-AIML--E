open System
open System.Text.RegularExpressions

// ---------- Task 1: Reverse and Palindrome ----------
let reverse (s: string) : string =
    s |> Seq.rev |> Seq.toArray |> String

let isPalindrome (s: string) : bool =
    let lower = s.ToLower()
    lower = reverse lower

// ---------- Task 2: Transform ----------

let transform (s: string) : string =
    match s with
    | "" -> s
    | _ when Seq.forall Char.IsLetter s -> s.ToUpper()
    | _ when Seq.forall Char.IsDigit s -> string ((int64 s) * 2L)
    | _ -> s

// ---------- Task 3: Email Validation ----------
let isValidEmail (email: string) : bool =
    let pattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
    Regex.IsMatch(email, pattern)

// ---------- Tests ----------
printfn "--- Reverse and Palindrome ---"
[ "madam"; "hello"; "Level" ]
|> List.iter (fun s ->
    printfn "\"%s\" reversed = \"%s\", palindrome = %b" s (reverse s) (isPalindrome s))

printfn "\n--- Transform ---"
[ "hello"; "123"; "abc123" ]
|> List.iter (fun s -> printfn "\"%s\" -> \"%s\"" s (transform s))

printfn "\n--- Email Validation ---"
[ "user@example.com"; "bad.email@"; "john_doe@mail.co.in" ]
|> List.iter (fun e -> printfn "\"%s\" valid = %b" e (isValidEmail e))