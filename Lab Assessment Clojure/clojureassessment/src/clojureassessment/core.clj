(ns clojureassessment.core
  (:gen-class))

(defn -main
  [& args]

  (def students [{:id 1 :name "Shyam" :marks 85}
                 {:id 2 :name "Rekha" :marks 45}
                 {:id 3 :name "Meena" :marks 72}
                 {:id 4 :name "Amit" :marks 30}])

  (println "Names:")
  (println (map :name students))

  (println "Passed students:")
  (def passed (filter (fn [s] (>= (:marks s) 40)) students))
  (println passed)

  (println "Total marks:")
  (def total (reduce + (map :marks students)))
  (println total)

  (println "Average marks:")
  (println (/ total 4))

  (println "Transducer test - passed marks + 5:")
  (def my-transducer (comp (filter (fn [s] (>= (:marks s) 40)))
                           (map (fn [s] (+ (:marks s) 5)))))
  (println (transduce my-transducer + students))

  (defn my-handler [request]
    (if (= (:uri request) "/students")
      {:status 200 :body (str students)}
      {:status 200 :body "Go to /students"}))

  (println "When we call /students:")
  (println (my-handler {:uri "/students"}))

  (def mydb (atom []))

  (try
    (reset! mydb students)
    (spit "students.db.txt" (str @mydb))

    (catch Exception e
      (println "Error in saving")
      (println (.getMessage e))))

  (try
    (def data (slurp "students.db.txt"))
    (println data)
    (catch Exception e
      (println "Error in reading")
      (println (.getMessage e))))

  (println "Error handling test")
  (try
    (slurp "wrong-file.txt")
    (catch Exception e
      (println "Error caught:")
      (println (.getMessage e))))

  (println "Square root of 144")
  (println (Math/sqrt 144))

  (println "ArrayList")
  (def l (java.util.ArrayList.))
  (.add l "Ashutosh")
  (.add l "Rohit")
  (.add l "Sita")
  (.add l "Riya")
  (println (str l))
  (println "Size")
  (println (.size l)))

