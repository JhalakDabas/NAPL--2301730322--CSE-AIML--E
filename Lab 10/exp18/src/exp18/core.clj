(ns exp18.core
  (:gen-class))

(defn -main
  [& args]
  (let [nums1 [1 2 3 4 5 6 7 8 9 10]
        nums2 [15 4 8 23 42 16 7]]
    (println "map (square):" (map #(* % %) nums1) (map #(* % %) nums2))
    (println "filter (even):" (filter even? nums1) (filter even? nums2))
    (println "reduce (sum):" (reduce + nums1) (reduce + nums2))
    (println "reduce (max):" (reduce max nums1) (reduce max nums2))
    (println "take 3:" (take 3 nums1) "| drop 3:" (drop 3 nums1))
    (println "->> chain:" (->> nums1 (map #(* % %)) (filter even?) (reduce +)))
    (println "->> chain:" (->> nums2 (map #(* % %)) (filter even?) (reduce +)))
    (println "-> chain:" (-> 5 (+ 10) (* 2) (- 4)))))