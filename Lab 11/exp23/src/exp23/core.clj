(ns exp23.core
  (:gen-class))

;; ---------- (2) Function that deliberately throws a custom exception ----------
(defn withdraw
  "Withdraws amount from balance. Throws a custom ex-info if invalid."
  [balance amount]
  (cond
    (neg? amount)
    (throw (ex-info "Invalid amount: cannot be negative"
                    {:type :invalid-amount :amount amount}))

    (> amount balance)
    (throw (ex-info "Insufficient funds"
                    {:type :insufficient-funds
                     :balance balance
                     :requested amount
                     :shortfall (- amount balance)}))

    :else (- balance amount)))

;; ---------- (3) Graceful recovery using ex-message and ex-data ----------
(defn safe-withdraw
  "Calls withdraw but recovers from errors instead of crashing."
  [balance amount]
  (try
    (let [new-balance (withdraw balance amount)]
      (println "  Success! New balance:" new-balance)
      new-balance)
    (catch clojure.lang.ExceptionInfo e
      (println "  Error message :" (ex-message e))
      (println "  Error data    :" (ex-data e))
      (case (:type (ex-data e))
        :insufficient-funds
        (println "  Recovery      : You are short by" (:shortfall (ex-data e)))
        :invalid-amount
        (println "  Recovery      : Please enter a positive amount")
        (println "  Recovery      : Unknown error"))
      balance)))                       ; recover by returning the old balance

(defn -main
  [& args]

  ;; ---------- (1a) ArithmeticException ----------
  (println "===== 1. ArithmeticException =====")
  (try
    (println "Trying 10 / 0 ...")
    (println (/ 10 0))
    (catch ArithmeticException e
      (println "Caught ArithmeticException:" (.getMessage e)))
    (finally
      (println "Finally: this always runs\n")))

  ;; ---------- (1b) NullPointerException ----------
  (println "===== 2. NullPointerException =====")
  (try
    (println "Trying to call .length on nil ...")
    (let [s nil]
      (println (.length s)))
    (catch NullPointerException e
      (println "Caught NullPointerException (null value used)"))
    (finally
      (println "Finally: this always runs\n")))

  ;; ---------- (1c) Another built-in exception: NumberFormatException ----------
  (println "===== 3. NumberFormatException =====")
  (try
    (println "Trying Integer/parseInt \"abc\" ...")
    (println (Integer/parseInt "abc"))
    (catch NumberFormatException e
      (println "Caught NumberFormatException:" (.getMessage e)))
    (finally
      (println "Finally: this always runs\n")))

  ;; ---------- (1d) Custom exception using ex-info ----------
  (println "===== 4. Custom exception (ex-info) =====")
  (try
    (println "Trying withdraw 100 from balance 50 ...")
    (withdraw 50 100)
    (catch clojure.lang.ExceptionInfo e
      (println "Caught ExceptionInfo")
      (println "ex-message:" (ex-message e))
      (println "ex-data   :" (ex-data e)))
    (finally
      (println "Finally: this always runs\n")))

  ;; ---------- Multiple catch blocks, most specific first ----------
  (println "===== 5. Multiple catch blocks =====")
  (doseq [f [(fn [] (/ 1 0))
             (fn [] (Integer/parseInt "xyz"))
             (fn [] (withdraw 10 -5))]]
    (try
      (f)
      (catch ArithmeticException e
        (println "Arithmetic problem:" (.getMessage e)))
      (catch NumberFormatException e
        (println "Number format problem:" (.getMessage e)))
      (catch clojure.lang.ExceptionInfo e
        (println "Custom problem:" (ex-message e)))
      (finally
        (println "  (cleanup done)"))))

  ;; ---------- (3) Graceful recovery ----------
  (println "\n===== 6. Graceful recovery =====")
  (println "Withdraw 30 from 100:")
  (let [b (safe-withdraw 100 30)]
    (println "Withdraw 500 from" b ":")
    (let [b2 (safe-withdraw b 500)]
      (println "Withdraw -20 from" b2 ":")
      (let [b3 (safe-withdraw b2 -20)]
        (println "Program continues normally. Final balance:" b3)))))