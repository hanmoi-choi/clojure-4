(ns clojure-4.q_61_to_70)

;; Q61. Pack a Sequence
;(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
;; ans: #(partition-by identity %)

;; Q62. Drop Every Nth Item
;(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
;; ans:
(fn [coll e]
  (flatten (map #(if (= (count %) e)
                  (butlast %)
                  %) (partition-all e coll))))

;; Q63. Intro to Destructuring
;(= [2 4] (let [[a b c d e f g] (range)] __))
;; ans: [c e]

;; Q64. Split a sequence
;(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
;(= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
;(= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])
;; ans:
(fn [n coll]
  [(take n coll) (drop n coll)])

;; Q65. Advanced Destructuring
;(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
;; ans: [1 2 3 4 5]

;; Q66. A Half-Truth
;(= false (__ false false))
;(= true (__ true false))
;(= false (__ true))
;(= true (__ false true false))
;(= false (__ true true true))
;; ans:
(fn [& coll]
  (cond
    (every? true? coll) false
    :else (reduce #(or %1 %2) coll)))

;; Q67. Map Construction
;(= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
;(= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
;(= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
;;ans: #(apply hash-map (interleave %1 %2))

;; Q68. Greatest Common Divisor
;(= (__ 2 4) 2)
;(= (__ 10 5) 5)
;(= (__ 5 7) 1)
;; ans:
(fn [fst snd]
  (letfn [(gcd [f s]
               (if (= s 0)
                 f
                 (gcd s (mod f s) )))]
    (gcd fst snd)))

;; Q69. Comparisons
;(= :gt (__ < 5 1))
;(= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum"))
;(= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3))
;(= :gt (__ > 0 2))
;; ans:
#(cond
  (%1 %2 %3) :lt
  (%1 %3 %2) :gt
  :else :eq)

;; Q70. Set Intersection
;(= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
;(= (__ #{0 1 2} #{3 4 5}) #{})
;(= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
;; ans:
(fn [fl sl]
  (let [el (for [f fl
                 s sl
                 :when (= f s)]
             f)]
    (set el)))
