#r "nuget: Microsoft.Data.Sqlite"

open System
open Microsoft.Data.Sqlite

// In-memory database, so no file is needed
let connection = new SqliteConnection("Data Source=:memory:")
connection.Open()

// Helper: run a command that changes data (CREATE, INSERT, UPDATE, DELETE)
let execute (sql: string) (parameters: (string * obj) list) =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- sql
    for (name, value) in parameters do
        cmd.Parameters.AddWithValue(name, value) |> ignore
    cmd.ExecuteNonQuery() |> ignore

// Helper: print all students (the "Read" operation)
let printStudents (title: string) =
    printfn "\n%s" title
    use cmd = connection.CreateCommand()
    cmd.CommandText <- "SELECT Id, Name, Age, Course FROM Student"
    use reader = cmd.ExecuteReader()
    let mutable count = 0
    while reader.Read() do
        printfn "  Id=%d | Name=%s | Age=%d | Course=%s"
            (reader.GetInt32(0)) (reader.GetString(1)) (reader.GetInt32(2)) (reader.GetString(3))
        count <- count + 1
    if count = 0 then printfn "  (no records)"

// ---------- Create table ----------
execute "CREATE TABLE Student (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER, Course TEXT)" []
printfn "Table 'Student' created."

// ---------- CREATE ----------
execute "INSERT INTO Student (Id, Name, Age, Course) VALUES (@id, @name, @age, @course)"
        [ "@id", box 1; "@name", box "Asha"; "@age", box 20; "@course", box "CSE" ]
execute "INSERT INTO Student (Id, Name, Age, Course) VALUES (@id, @name, @age, @course)"
        [ "@id", box 2; "@name", box "Ravi"; "@age", box 21; "@course", box "IT" ]
execute "INSERT INTO Student (Id, Name, Age, Course) VALUES (@id, @name, @age, @course)"
        [ "@id", box 3; "@name", box "Meena"; "@age", box 22; "@course", box "ECE" ]
printStudents "After CREATE (3 students inserted):"

// ---------- READ (one record) ----------
printfn "\nREAD one student (Id = 2):"
use readCmd = connection.CreateCommand()
readCmd.CommandText <- "SELECT Name, Course FROM Student WHERE Id = @id"
readCmd.Parameters.AddWithValue("@id", 2) |> ignore
use r = readCmd.ExecuteReader()
if r.Read() then printfn "  Found: %s (%s)" (r.GetString(0)) (r.GetString(1))

// ---------- UPDATE ----------
execute "UPDATE Student SET Age = @age, Course = @course WHERE Id = @id"
        [ "@age", box 23; "@course", box "AI&DS"; "@id", box 1 ]
printStudents "After UPDATE (Asha's age and course changed):"

// ---------- DELETE ----------
execute "DELETE FROM Student WHERE Id = @id" [ "@id", box 3 ]
printStudents "After DELETE (Meena removed):"

connection.Close()