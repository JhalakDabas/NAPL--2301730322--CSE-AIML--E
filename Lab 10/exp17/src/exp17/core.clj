(ns exp17.core
  (:gen-class))

(defn -main
  [& args]
  ;; ---------- (1) LIST ----------
  (println "===== LIST =====")
  (let [my-list '(10 20 30)
        new-list (conj my-list 5)]
    (println "Original list :" my-list)
    (println "first         :" (first my-list))
    (println "rest          :" (rest my-list))
    (println "After conj 5  :" new-list)
    (println "Original again:" my-list))

  ;; ---------- (2) VECTOR ----------
  (println "\n===== VECTOR =====")
  (let [my-vec [1 2 3]
        new-vec (conj my-vec 4)]
    (println "Original vector:" my-vec)
    (println "get index 1    :" (get my-vec 1))
    (println "count          :" (count my-vec))
    (println "After conj 4   :" new-vec)
    (println "New count      :" (count new-vec))
    (println "Original again :" my-vec))

  ;; ---------- (3) MAP ----------
  (println "\n===== MAP =====")
  (let [my-map {:name "Asha" :age 20}
        map-added (assoc my-map :course "CSE")
        map-removed (dissoc my-map :age)]
    (println "Original map   :" my-map)
    (println "get :name      :" (get my-map :name))
    (println "After assoc    :" map-added)
    (println "After dissoc   :" map-removed)
    (println "Original again :" my-map))

  ;; ---------- (4) SET ----------
  (println "\n===== SET =====")
  (let [my-set #{1 2 3}
        set-added (conj my-set 4)
        set-removed (disj my-set 2)]
    (println "Original set   :" my-set)
    (println "contains? 2    :" (contains? my-set 2))
    (println "contains? 9    :" (contains? my-set 9))
    (println "After conj 4   :" set-added)
    (println "After disj 2   :" set-removed)
    (println "Original again :" my-set)))