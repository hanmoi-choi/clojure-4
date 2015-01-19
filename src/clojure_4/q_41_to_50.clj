(ns clojure-4.q_41_to_50)

;; Q41. Nth Element
;(= (__ '(4 5 6 7) 2) 6)
;(= (__ [:a :b :c] 0) :a)
;(= (__ [1 2 3 4] 1) 2)
;(= (__ '([1 2] [3 4] [5 6]) 2) [5 6])
;; ans: #(first(drop %2 %1))

;; Q42. Count a Sequence
;(= (__ '(1 2 3 3 1)) 5)
;(= (__ "Hello World") 11)
;(= (__ [[1 2] [3 4] [5 6]]) 3)
;(= (__ '(13)) 1)
;(= (__ '(:a :b :c)) 3)
;; ans: #(alength (to-array %))

;; Q43. Sum It All Up
;(= (__ [1 2 3]) 6)
;(= (__ (list 0 -2 5 5)) 8)
;(= (__ #{4 2 1}) 7)
;(= (__ '(0 0 -1)) -1)
;; ans: apply +

;; Q44. Find the odd numbers
;(= (__ #{1 2 3 4 5}) '(1 3 5))
;(= (__ [4 2 1 6]) '(1))
;; ans: filter odd?

;; Q45. Reverse a Sequence
;(= (__ [1 2 3 4 5]) [5 4 3 2 1])
;(= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
;; ans: #(into () %)

;; Q46. Palindrome Detector
;(false? (__ '(1 2 3 4 5)))
;(true? (__ "racecar"))
;(true? (__ [:foo :bar :foo]))
;(true? (__ '(1 1 3 3 1 1)))
;; ans: #(=  (seq %) (reverse %))

;; Q47. Fibonacci Sequence
;(= (__ 3) '(1 1 2))
;(= (__ 6) '(1 1 2 3 5 8))
;(= (__ 8) '(1 1 2 3 5 8 13 21))
;; ans:
; #(take % ((fn [e1 e2]
;(letfn [
;        (fib [f s]
;             (cons f (lazy-seq (fib s (+ f s)))))]
;  (fib e1 e2))) 1 1

;; Q48. Maximum value
;(= (__ 1 8 3 4) 8)
;(= (__ 30 20) 30)
;; ans: #(last (sort (seq %&)))

;; Q49. Get the Caps
;(= (__ "HeLlO, WoRlD!") "HLOWRD")
;(empty? (__ "nothing"))
;(= (__ "$#A(*&987Zf") "AZ")
;;ans: #(apply str (re-seq #"[A-Z]" %))

;; Q50. Duplicate a Sequence
;(= (__ [1 2 3]) '(1 1 2 2 3 3))
;(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
;;ans: (fn [l] (mapcat  #(if (sequential? %) % [%]) (map #(conj [] % %) l)))
