open System
open System.IO

// Q1
type Student = {
    Id: int
    Name: string
    Marks: int
}

let mutable students = [
    { Id = 1; Name = "Aman"; Marks = 85 }
    { Id = 2; Name = "Riya"; Marks = 45 }
    { Id = 3; Name = "Rahul"; Marks = 72 }
]

let printStudents title list =
    printfn "%s" title
    list |> List.iter (fun s -> printfn "Id=%d Name=%s Marks=%d" s.Id s.Name s.Marks)

printStudents "Students:" students
printfn "Total students: %d" students.Length

// Q2
let getGrade marks =
    match marks with
    | m when m >= 80 -> "A"
    | m when m >= 60 -> "B"
    | m when m >= 40 -> "C"
    | _ -> "Fail"

let withGrades = students |> List.map (fun s -> s.Name, getGrade s.Marks)
printfn "Grades:"
withGrades |> List.iter (fun (name, grade) -> printfn "%s -> %s" name grade)

let passed = students |> List.filter (fun s -> s.Marks >= 40)
printStudents "Passed:" passed

let failed = students |> List.filter (fun s -> s.Marks < 40)
printfn "Failed count: %d" failed.Length

// Q3
let filePath = "students.txt"

let saveAsync () = async {
    let lines = students |> List.map (fun s -> sprintf "%d,%s,%d" s.Id s.Name s.Marks)
    do! File.WriteAllLinesAsync(filePath, lines) |> Async.AwaitTask
    printfn "Saved to file!"
}

let loadAsync () = async {
    if File.Exists(filePath) then
        let! lines = File.ReadAllLinesAsync(filePath) |> Async.AwaitTask
        printfn "Loaded from file:"
        lines |> Array.iter (fun l -> printfn "%s" l)
    else
        printfn "No file found"
}

students <- students @ [ { Id = 4; Name = "Priya"; Marks = 90 } ]
printStudents "After Add:" students

students <- students |> List.map (fun s -> if s.Id = 2 then { s with Marks = 55 } else s)
printStudents "After Update:" students

students <- students |> List.filter (fun s -> s.Id <> 3)
printStudents "After Delete:" students

saveAsync () |> Async.RunSynchronously
loadAsync () |> Async.RunSynchronously
