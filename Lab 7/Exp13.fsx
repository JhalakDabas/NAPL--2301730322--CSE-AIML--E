open System.Diagnostics

let task (name: string) (delayMs: int) (value: int) : Async<string * int> =
    async {
        printfn "[START]  %s (will take %d ms)" name delayMs
        do! Async.Sleep delayMs
        printfn "[FINISH] %s" name
        return (name, value)
    }

let stopwatch = Stopwatch.StartNew()

printfn "Starting all tasks in parallel...\n"

let results =
    [ task "Task A (download file)" 1500 10
      task "Task B (query database)" 1000 20
      task "Task C (read config)" 500 30 ]
    |> Async.Parallel
    |> Async.RunSynchronously

stopwatch.Stop()

printfn "\nAll tasks complete. Results:"
results |> Array.iter (fun (name, value) -> printfn "  %s -> %d" name value)

let total = results |> Array.sumBy snd
printfn "Sum of all results: %d" total
printfn "Total time: %d ms (sequential would be 3000 ms)" stopwatch.ElapsedMilliseconds