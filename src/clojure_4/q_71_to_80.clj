(ns clojure-4.q_61_to_70)

;; Q71. Re-implement Iterate
;(= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
;(= (take 100 (__ inc 0)) (take 100 (range)))
;(= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))
;; ans:
(fn iter [f x]
  (cons x (lazy-seq (iter f (f x)))))

;; Q72. Simple closures
;(= 256 ((__ 2) 16), ((__ 8) 2))
;(= [1 8 27 64] (map (__ 3) [1 2 3 4]))
;(= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))
;; ans:
(fn [x]
  #(reduce * (take x (repeat %))))

;; Q73. Product Digits
;(= (__ 1 1) [1])
;(= (__ 99 9) [8 9 1])
;(= (__ 999 99) [9 8 9 0 1])
;; ans:
(fn [f s]
  (map #(Integer/parseInt (str %)) (seq (str (* f s)))))

;; Q74. Cartesian Product
;(= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
;   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
;     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
;     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})
;(= (__ #{1 2 3} #{4 5})
;   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
;
;(= 300 (count (__ (into #{} (range 10))
;                  (into #{} (range 30)))))
;; ans:
(fn [fl sl]
  (set (for [f fl
             s sl]
         [f s])))

;; Q75. Group a Sequence
;(= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
;(= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
;   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
;(= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
;   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
;; ans:
(fn [f col]
  (reduce (fn [ret e]
            (let [k (f e)]
              (assoc ret k (conj (get ret k []) e)))) {} col))

;; Q76. Read a binary number
;(= 0     (__ "0"))
;(= 7     (__ "111"))
;(= 8     (__ "1000"))
;(= 1365  (__ "10101010101"))
;(= 65535 (__ "1111111111111111"))
;; ans:
(fn [bin-str]
  (reduce + (map #(* (first %) (last %)) (map vector (map #(Integer/parseInt (str %)) (reverse (seq bin-str))) (iterate (partial * 2) 1)))))

;; Q77. Symmetric Difference
;(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
;(= (__ #{:a :b :c} #{}) #{:a :b :c})
;(= (__ #{} #{4 5 6}) #{4 5 6})
;(= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
;; ans:
(fn [fl sl]
  (let [fs (filter #(not (contains? sl %)) fl)
        ss (filter #(not (contains? fl %)) sl)]
    (set (concat fs ss))))

;; Q78. dot product
;(= 0 (__ [0 1 0] [1 0 0]))
;(= 3 (__ [1 1 1] [1 1 1]))
;(= 32 (__ [1 2 3] [4 5 6]))
;(= 256 (__ [2 5 6] [100 10 1]))
;; ans:
(fn [f s] (reduce + (map * f s)))

;; Q79. Through the Looking Class
;(let [x __]
;  (and (= (class x) x) x))
;; ans: java.lang.Class

;; Q80. Infix Calculator
;(= 7  (__ 2 + 5))
;(= 42 (__ 38 + 48 - 2 / 2))
;(= 8  (__ 10 / 2 - 1 * 2))
;(= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))
;; ans:
(fn [& infix-notation]
  (letfn [(infix [l & coll]
                 (let [[op r & rest] coll
                       result (op l r)]
                   (if (nil? rest)
                     result
                     (apply infix result rest))))]
    (apply infix infix-notation)))
