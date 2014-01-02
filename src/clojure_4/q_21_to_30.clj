(ns clojure-4.q_1_to_10)

;; Q21. Nth Element
;; (= (__ '(4 5 6 7) 2) 6)
(= (#(first(drop %2 %1)) '(4 5 6 7) 2) 6)

;; Q22. Intro to Sequences
;; (= __ (first '(3 2 1)))
(= 3 (first '(3 2 1)))

;; Q23. Let it be
;; (= 10 (let __ (+ x y)))
;; (= 4 (let __ (+ y z)))
;; (= 1 (let __ z))
(= 10 (let [z 1 y 3 x 7] (+ x y)))

;; Q24. Count a Sequence
;; (= (__ '(1 2 3 3 1)) 5)
;;(= (__ '(1 2 3 3 1)) 5)

;; Q25. Regular Expressions
;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; Q26. Sum It All Up
;; (= (__ [1 2 3]) 6)
;; (= (__ (list 0 -2 5 5)) 8)

;; Q27. Intro to Reduce
;; (= 15 (reduce __ [1 2 3 4 5]))
;; (=  0 (reduce __ []))
(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))

;; Q18. Sequences: filter
;; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; Q19. Last Element
;; (= (__ [1 2 3 4 5]) 5)
(= (#(nth (reverse %) 0) [1 2 3 4 5]) 5)

;; Q20. Penultimate Element
;; (= (__ (list 1 2 3 4 5)) 4)
(= (#(nth (reverse %) 1) (list 1 2 3 4 5)) 4)
