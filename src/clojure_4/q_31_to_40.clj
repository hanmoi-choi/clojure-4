(ns clojure-4.q_31_to_40)

;; Q31. Map Defaults
;(= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0})
;(= (__ "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
;(= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})
;; ans: (fn [n l] (apply merge (map #(hash-map % n) l)))

;; TODO(daniel): to be resolved
;; Q32. Pascal's Triangle
;(= (__ 1) [1])
;(= (map __ (range 1 6))
;   [     [1]
;    [1 1]
;    [1 2 1]
;    [1 3 3 1]
;    [1 4 6 4 1]])
;(= (__ 11)
;   [1 10 45 120 210 252 210 120 45 10 1])

;; TODO(daniel): to be resolved
;; Q33. Re-implement Map
;(= [3 4 5 6 7]
;   (__ inc [2 3 4 5 6]))
;(= (repeat 10 nil)
;   (__ (fn [_] nil) (range 10)))
;(= [1000000 1000001]
;   (->> (__ inc (range))
;        (drop (dec 1000000))
;        (take 2)))
;Special Restrictions:  map map-indexed mapcat for

;; TODO(daniel): to be resolved
;; Q34. Least Common Multiple
;(== (__ 2 3) 6)
;(== (__ 5 3 7) 105)
;(== (__ 1/3 2/5) 2)
;(== (__ 3/4 1/6) 3/2)
;(== (__ 7 5/7 2 3/5) 210)

;; TODO(daniel): to be resolved
;; Q35. Pascal's Trapezoid
;(= (second (__ [2 3 2])) [2 5 5 2])
;(= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
;(= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])
;(= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))

;; TODO(daniel): to be resolved
;; Q36. Beauty is Symmetry
;(= (__ '(:a (:b nil nil) (:b nil nil))) true)
;(= (__ '(:a (:b nil nil) nil)) false)
;(= (__ '(:a (:b nil nil) (:c nil nil))) false)
;(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
;        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
;   true)
;(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
;        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
;   false)
;(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
;        [2 [3 nil [4 [6 nil nil] nil]] nil]])
;   false)

;; TODO(daniel): to be resolved
;; Q37. Trees into tables
;(= (__ '{a {p 1, q 2}
;         b {m 3, n 4}})
;   '{[a p] 1, [a q] 2
;     [b m] 3, [b n] 4})
;
;(= (__ '{[1] {a b c d}
;         [2] {q r s t u v w x}})
;   '{[[1] a] b, [[1] c] d,
;     [[2] q] r, [[2] s] t,
;     [[2] u] v, [[2] w] x})
;
;(= (__ '{m {1 [a b c] 3 nil}})
;   '{[m 1] [a b c], [m 3] nil})

;; TODO(daniel): to be resolved
;; Q38. Pairwise Disjoint Sets
;(= (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
;   true)
;(= (__ #{#{:a :b :c :d :e}
;         #{:a :b :c :d}
;         #{:a :b :c}
;         #{:a :b}
;         #{:a}})
;   false)
;(= (__ #{#{[1 2 3] [4 5]}
;         #{[1 2] [3 4 5]}
;         #{[1] [2] 3 4 5}
;         #{1 2 [3 4] [5]}})
;   true)
;(= (__ #{#{'a 'b}
;         #{'c 'd 'e}
;         #{'f 'g 'h 'i}
;         #{''a ''c ''f}})
;   true)
;(= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
;         #{#{:x :y :z} #{:x :y} #{:z} #{}}
;         #{'[:x :y :z] [:x :y] [:z] [] {}}})
;   false)
;(= (__ #{#{(= "true") false}
;         #{:yes :no}
;         #{(class 1) 0}
;         #{(symbol "true") 'false}
;         #{(keyword "yes") ::no}
;         #{(class '1) (int \0)}})
;   false)
;(= (__ #{#{distinct?}
;         #{#(-> %) #(-> %)}
;         #{#(-> %) #(-> %) #(-> %)}
;         #{#(-> %) #(-> %) #(-> %)}})
;   true)
;(= (__ #{#{(#(-> *)) + (quote mapcat) #_ nil}
;         #{'+ '* mapcat (comment mapcat)}
;         #{(do) set contains? nil?}
;         #{, , , #_, , empty?}})
;   false)

;; Q39. Last Element
;; (= (__ [1 2 3 4 5]) 5)
(= (#(nth (reverse %) 0) [1 2 3 4 5]) 5)

;; Q40. Penultimate Element
;; (= (__ (list 1 2 3 4 5)) 4)
(= (#(nth (reverse %) 1) (list 1 2 3 4 5)) 4)
