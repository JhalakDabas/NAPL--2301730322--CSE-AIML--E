open System

// ---------- Base class with a virtual method ----------
[<AbstractClass>]
type Shape(name: string) =
    member this.Name = name
    // abstract = must be overridden; default = has a base version
    abstract Area : unit -> float
    default this.Area() = 0.0

    abstract Describe : unit -> string
    default this.Describe() = sprintf "%s with area %.2f" name (this.Area())

// ---------- Derived class 1: Circle ----------
type Circle(radius: float) =
    inherit Shape("Circle")
    member this.Radius = radius
    override this.Area() = Math.PI * radius * radius

// ---------- Derived class 2: Rectangle ----------
type Rectangle(width: float, height: float) =
    inherit Shape("Rectangle")
    member this.Width = width
    member this.Height = height
    override this.Area() = width * height

// ---------- Derived class 3: Triangle ----------
type Triangle(baseLen: float, height: float) =
    inherit Shape("Triangle")
    override this.Area() = 0.5 * baseLen * height

// ---------- Create objects ----------
let circle = Circle(5.0)
let rectangle = Rectangle(4.0, 6.0)
let triangle = Triangle(3.0, 8.0)

printfn "--- Calling methods directly ---"
printfn "Circle area:    %.2f" (circle.Area())
printfn "Rectangle area: %.2f" (rectangle.Area())
printfn "Triangle area:  %.2f" (triangle.Area())

// ---------- Polymorphism: one list of Shape, different behavior ----------
let shapes : Shape list =
    [ circle :> Shape
      rectangle :> Shape
      triangle :> Shape ]

printfn "\n--- Polymorphism (same call, different results) ---"
for s in shapes do
    printfn "%s" (s.Describe())

let totalArea = shapes |> List.sumBy (fun s -> s.Area())
printfn "\nTotal area of all shapes: %.2f" totalArea