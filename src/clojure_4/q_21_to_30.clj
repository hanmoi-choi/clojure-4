(ns clojure-4.q_21_to_30)

;; Q21. Regular Expressions
;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; Q22. Intro to Reduce
;; (= 15 (reduce __ [1 2 3 4 5]))
;; (=  0 (reduce __ []))
(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))

;; Q23. Simple Recursion
;; (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))
;; ans: `(5 4 3 2 1)

;; Q24. Rearranging Code: ->
;(= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
;   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
;   5)
;; Ans: last

;; Q25. Recurring Theme
;(= __
;   (loop [x 5
;          result []]
;     (if (> x 0)
;       (recur (dec x) (conj result (+ 2 x)))
;       result)))
;; Ans: `(7 6 5 4 3)

;; Q26. Rearranging Code: ->>
;(= (__ (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
;   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (__))
;   11)
;; reduce +

;; Q27. A nil key
;(true?  (__ :a {:a nil :b 2}))
;(false? (__ :b {:a nil :b 2}))
; ans: #(and (contains? %2 %1) (nil? (%1 %2)))

;; Q28. For the win
;(= __ (for [x (range 40)
;            :when (= 1 (rem x 4))]
;        x))

;(= __ (for [x (iterate #(+ 4 %) 0)
;            :let [z (inc x)]
;            :while (< z 40)]
;        z))

;(= __ (for [[x y] (partition 2 (range 20))]
;        (+ x y)))
;; ans: `(1 5 9 13 17 21 25 29 33 37)

;; Q29. Logical falsity and truth
;(= __ (if-not false 1 0))
;(= __ (if-not nil 1 0))
;(= __ (if true 1 0))
;(= __ (if [] 1 0))
;; ans: 1

;; Q30. Subset and Superset
(clojure.set/superset? __ #{2})
(clojure.set/subset? #{1} __)
(clojure.set/superset? __ #{1 2})
(clojure.set/subset? #{1 2} __)
;; ans: #{1 2}
