(ns clojure-4.q_51_to_60)

;; Q51. Intro to some
;(= __ (some #{2 7 6} [5 6 7 8]))
;(= __ (some #(when (even? %) %) [5 6 7 8]))
;; ans: 6

;; Q52. Implement range
;(= (__ 1 4) '(1 2 3))
;(= (__ -2 2) '(-2 -1 0 1))
;(= (__ 5 8) '(5 6 7))
;; ans:#(take (- %2 %1) (iterate inc %1))

;; Q53. Flatten a Sequence
;; Special Restrictions flatten
;(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;(= (__ '((((:a))))) '(:a))
;; ans:
(fn [coll]
  (letfn [(flatten' [h & rest]
                    (cond
                      (sequential? h) (concat (apply flatten' h) (flatten' rest))
                      (nil? h) nil
                      :else (concat [h] (flatten' rest))))] (flatten' coll)))

;; Q54. Interleave Two Seqs
;Special Restrictions interleave
;(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;(= (__ [1 2 3 4] [5]) [1 5])
;(= (__ [30 20] [25 15]) [30 25 20 15])
;; ans:
(fn [f s]
  (flatten (map vector f (take (count f) s))))

;; Q55. Factorial Fun
;(= (__ 1) 1)
;(= (__ 3) 6)
;(= (__ 5) 120)
;(= (__ 8) 40320)
;; ans: #(apply * (range 1 (inc %)))

;; Q56. Compress a Sequence
;(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
;; ans: #(map first (partition-by identity %))

;; Q57. Contain Yourself
;(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
;(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; ans: #(map first (partition-by identity %))


;; Q58. Replicate a Sequence
;(= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;(= (__ [4 5 6] 1) '(4 5 6))
;(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;; ans:
(fn [coll r]
  (mapcat #(if (sequential? %) % [%]) (apply map vector (take r (repeat coll)))))

;; Q59. Intro to Iterate
;(= __ (take 5 (iterate #(+ 3 %) 1)))
;; ans: `(1 4 7 10 13)

;; Q60. Interpose a Seq
(= (__ 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
;; ans:
(fn [j coll]
  (butlast (flatten (map vector coll (take (count coll) (repeat j))))))
