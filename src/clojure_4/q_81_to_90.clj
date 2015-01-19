(ns clojure-4.q_61_to_70)

;; Q81. Indexing Sequences
;(= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
;(= (__ [0 1 3]) '((0 0) (1 1) (3 2)))
;(= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])
;; ans:
#(map vector % (iterate inc 0))

;; Q82. Sum of square of digits
;(= 8 (__ (range 10)))
;(= 19 (__ (range 30)))
;(= 50 (__ (range 100)))
;(= 50 (__ (range 1000)))
;; ans:
(fn fil [col]
  (letfn [(to-int [c]
                  (Integer/parseInt (str c)))
          (to-char-array [n]
                         (seq (str n)))
          (to-int-array [n]
                        (map to-int (to-char-array n)))
          (square-sum-each-digit [nl]
                                 (reduce + (map #(* % %) nl)))]
    (count (filter #(> (square-sum-each-digit (to-int-array %)) %) col))))

;; Q83. To Tree, or not to Tree
;(= (__ '(:a (:b nil nil) nil))
;   true)
;(= (__ '(:a (:b nil nil)))
;   false)
;(= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
;   true)
;(= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
;   false)
;(= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
;   true)
;(= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
;   false)
;(= (__ '(:a nil ()))
;   false)
;; ans:
(fn [coll]
  (letfn [(ct [coll]
              (cond
                (not (sequential? coll)) true
                (and (sequential? coll)
                     (not= (count coll) 3)
                     ) false
                (and
                  (not (sequential? (nth coll 1)))
                  (not (nil? (nth coll 1)))) false
                :else (and
                        (ct (first coll))
                        (ct (nth coll 1))
                        (ct (last coll)))))]
    (ct coll)))
;; Q84. Recognize Playing Cards
;(= {:suit :diamond :rank 10} (__ "DQ"))
;(= {:suit :heart :rank 3} (__ "H5"))
;(= {:suit :club :rank 12} (__ "CA"))
;(= (range 13) (map (comp :rank __ str)
;                   '[S2 S3 S4 S5 S6 S7
;                     S8 S9 ST SJ SQ SK SA]))
;; ans:
(fn [st]
  (let [s (str (nth st 0))
        r (str (nth st 1))
        suits {"D" :diamond
               "H" :heart
               "C" :club
               "S" :spade}
        ranks (zipmap (concat (map str (range 2 10)) ["T" "J" "Q" "K" "A"]) (range 13))]
    {:suit (suits s) :rank (ranks r)}))

;; Q85. Intro to Destructuring 2
;(= 3
;   (let [[__] [+ (range 3)]] (apply __))
;   (let [[[__] b] [[+ 1] 2]] (__ b))
;   (let [[__] [inc 2]] (__)))
;; ans f c

;; From here level is Medium
