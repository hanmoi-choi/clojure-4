(ns clojure-4.q_31_to_40)

;; Q31. Map Defaults
;; Q32. Pascal's Triangle
;; Q33. Re-implement Map
;; Q34. Least Common Multiple
;; Q35. Pascal's Trapezoid
;; Q36. Beauty is Symmetry
;; Q37. Trees into tables
;; Q38. Pairwise Disjoint Sets
;; Q39. Last Element
;; (= (__ [1 2 3 4 5]) 5)
(= (#(nth (reverse %) 0) [1 2 3 4 5]) 5)

;; Q40. Penultimate Element
;; (= (__ (list 1 2 3 4 5)) 4)
(= (#(nth (reverse %) 1) (list 1 2 3 4 5)) 4)
