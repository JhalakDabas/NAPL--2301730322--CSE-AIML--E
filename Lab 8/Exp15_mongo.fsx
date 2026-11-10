#r "nuget: MongoDB.Driver"

open System
open MongoDB.Bson
open MongoDB.Driver

// ---------- Connect ----------
let client = MongoClient("mongodb://localhost:27017")
let database = client.GetDatabase("college")
let students = database.GetCollection<BsonDocument>("students")

// Start fresh so the demo gives the same output every time
database.DropCollection("students")

// Helper: print all documents (the "Read" operation)
let printStudents (title: string) =
    printfn "\n%s" title
    let docs = students.Find(FilterDefinition<BsonDocument>.Empty).ToList()
    if docs.Count = 0 then printfn "  (no records)"
    for d in docs do
        printfn "  Id=%d | Name=%s | Age=%d | Course=%s"
            (d.["_id"].AsInt32) (d.["name"].AsString) (d.["age"].AsInt32) (d.["course"].AsString)

// Helper: build a student document
let makeStudent (id: int) (name: string) (age: int) (course: string) =
    BsonDocument([ BsonElement("_id", BsonInt32 id)
                   BsonElement("name", BsonString name)
                   BsonElement("age", BsonInt32 age)
                   BsonElement("course", BsonString course) ])

// ---------- CREATE ----------
students.InsertOne(makeStudent 1 "Asha" 20 "CSE")
students.InsertMany([ makeStudent 2 "Ravi" 21 "IT"
                      makeStudent 3 "Meena" 22 "ECE" ])
printStudents "After CREATE (3 students inserted):"

// ---------- READ (one record) ----------
printfn "\nREAD one student (Id = 2):"
let filter = Builders<BsonDocument>.Filter.Eq("_id", 2)
let found = students.Find(filter).FirstOrDefault()
if not (isNull found) then
    printfn "  Found: %s (%s)" (found.["name"].AsString) (found.["course"].AsString)

// ---------- UPDATE ----------
let filter1 = Builders<BsonDocument>.Filter.Eq("_id", 1)
let update =
    Builders<BsonDocument>.Update
        .Set("age", 23)
        .Set("course", "AI&DS")
students.UpdateOne(filter1, update) |> ignore
printStudents "After UPDATE (Asha's age and course changed):"

// ---------- DELETE ----------
let filter3 = Builders<BsonDocument>.Filter.Eq("_id", 3)
students.DeleteOne(filter3) |> ignore
printStudents "After DELETE (Meena removed):"