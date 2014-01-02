(ns clojure-4.q_1_to_10)

;; Q1. Nothing but the Truth
;; (= __ true)
(= true true)

;; Q2. Simple Math
;; (= (- 10 (* 2 3)) __)
(= (- 10 (* 2 3)) 4)

;; Q3. Intro to Strings
;; (= __ (.toUpperCase "hello world"))
(= "HELLO WORLD" (.toUpperCase "hello world"))

;; Q4. Intro to Lists
;; (= (list __) '(:a :b :c))
(= (list :a :b :c) '(:a :b :c))

;; Q5. Lists: conj
;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))
(= '(1 2 3 4) (conj '(2 3 4) 1))

;; Q6. Intro to Vectors
;; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;; Q7. Vectors: conj
;; (= __ (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2 3] 4))

;; Q8. Intro to Sets
;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))

;; Q9. Sets: conj
;; (= #{1 2 3 4} (conj #{1 4 3} __))
(= #{1 2 3 4} (conj #{1 4 3} 2))

;; Q10. Intro to Maps
;; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
