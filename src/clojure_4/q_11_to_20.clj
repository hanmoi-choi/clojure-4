(ns clojure-4.q_1_to_10)

;; Q11. Maps: conj
;; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

;; Q12. Intro to Sequences
;; (= __ (first '(3 2 1)))
(= 3 (first '(3 2 1)))

;; Q13. Sequences: rest
;; (= __ (rest [10 20 30 40]))
(= [20 30 40] (rest [10 20 30 40]))

;; Q14. Intro to Functions
;; (= __ ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn add-five [x] (+ x 5)) 3))

;; Q15. Double Down
;; (= (__ 2) 4)
(= (#(* 2 %) 2) 4)

;; Q16. Hello World
;; (= (__ "Dave") "Hello, Dave!")
(= (#(format "Hello, %s!" %) "Dave") "Hello, Dave!")

;; Q17. Sequences: map
;; (= __ (map #(+ % 5) '(1 2 3)))
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;; Q18. Sequences: filter
;; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; Q19. Last Element
;; (= (__ [1 2 3 4 5]) 5)
(= (#(nth (reverse %) 0) [1 2 3 4 5]) 5)

;; Q20. Penultimate Element
;; (= (__ (list 1 2 3 4 5)) 4)
(= (#(nth (reverse %) 1) (list 1 2 3 4 5)) 4)
