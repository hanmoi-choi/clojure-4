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
;; Q25. Recurring Theme
;; Q26. Rearranging Code: ->>
;; Q27. A nil key
;; Q28. For the win
;; Q29. Logical falsity and truth
;; Q30. Subset and Superset
