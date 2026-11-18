(ns exp20.core
  (:gen-class)
  (:import (java.util ArrayList HashMap)))

(defn -main
  [& args]

  ;; ---------- (1) STATIC METHODS (dot notation: Class/method) ----------
  (println "===== (1) STATIC METHODS =====")
  (println "Math/abs -25             :" (Math/abs -25))
  (println "Math/sqrt 144            :" (Math/sqrt 144))
  (println "Math/pow 2 10            :" (Math/pow 2 10))
  (println "Math/max 10 42           :" (Math/max 10 42))
  (println "Integer/parseInt \"123\"   :" (Integer/parseInt "123"))
  (println "Math/PI (static field)   :" Math/PI)
  (println "System/currentTimeMillis :" (System/currentTimeMillis))

  ;; ---------- (2) CREATE JAVA OBJECTS ----------
  (println "\n===== (2) CREATE JAVA OBJECTS =====")
  (let [fruits (ArrayList.)          ; ClassName. syntax
        ages   (new HashMap)]        ; (new ClassName) syntax

    (println "Empty ArrayList :" fruits)
    (println "Empty HashMap   :" ages)

    ;; ---------- (3) INSTANCE METHODS (dot notation: (.method object)) ----------
    (println "\n===== (3) INSTANCE METHODS =====")

    ;; ArrayList methods
    (.add fruits "Apple")
    (.add fruits "Banana")
    (.add fruits "Cherry")
    (println "ArrayList after add   :" fruits)
    (println ".size                 :" (.size fruits))
    (println ".get 1                :" (.get fruits 1))
    (println ".contains \"Banana\"    :" (.contains fruits "Banana"))
    (println ".indexOf \"Cherry\"     :" (.indexOf fruits "Cherry"))

    ;; HashMap methods
    (.put ages "Asha" 20)
    (.put ages "Ravi" 21)
    (.put ages "Meena" 22)
    (println "\nHashMap after put     :" ages)
    (println ".get \"Ravi\"          :" (.get ages "Ravi"))
    (println ".containsKey \"Asha\"  :" (.containsKey ages "Asha"))
    (println ".size                 :" (.size ages))

    ;; Methods on a built-in Java String
    (println "\n.toUpperCase \"hello\"  :" (.toUpperCase "hello"))
    (println ".length \"hello\"        :" (.length "hello"))

    ;; ---------- (4) CONVERT BETWEEN CLOJURE AND JAVA COLLECTIONS ----------
    (println "\n===== (4) CONVERT COLLECTIONS =====")

    ;; Clojure -> Java
    (let [clj-vec (vector 1 2 3)
          clj-map {"a" 1 "b" 2}
          java-list (ArrayList. clj-vec)
          java-map  (HashMap. clj-map)]
      (println "Clojure vector  :" clj-vec)
      (println "-> ArrayList    :" java-list (class java-list))
      (println "Clojure map     :" clj-map)
      (println "-> HashMap      :" java-map (class java-map)))

    ;; Java -> Clojure
    (let [clj-vec (vec fruits)
          clj-set (set fruits)
          clj-map (into {} ages)]
      (println "\nArrayList -> vector :" clj-vec (class clj-vec))
      (println "ArrayList -> set    :" clj-set)
      (println "HashMap   -> map    :" clj-map (class clj-map))

      ;; Clojure copy is unaffected by later changes to the Java list
      (.add fruits "Date")
      (println "\nJava list after adding Date :" fruits)
      (println "Clojure vector (unchanged)  :" clj-vec))

    ;; Java array <-> Clojure
    (let [arr (into-array String ["x" "y" "z"])]
      (println "\nJava array length :" (alength arr))
      (println "Array -> vector   :" (vec arr)))))