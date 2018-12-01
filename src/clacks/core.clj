;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Clacks Messenger system
;; - Encoder / Decoder for Clacks notation
;;
;; A simple library to convert messages to
;; and from the Clacks notation
;; Conversion is via the Clacks alphabet
;; http://jr0cket.co.uk/2016/03/clacks-interpreter-going-postal-at-london-clojure-dojo.html

(ns clacks.core)

(def alphabet {"a" "010001"
               "b" "001010"
               "t" "100111"})

(def alphabet-inverted (clojure.set/map-invert alphabet))


(defn message-clacks
  "Converts a message to the Clacks notation"
  [message alphabet]
  (map
   (fn [character]
     (get alphabet (str character)))
   message))

(defn clacks-message
  "Converts a collection of Clacks notations to message using the alphabet"
  [clacks alphabet]
  (reduce
   str
   (map
    (fn [clack]
      (get alphabet clack))
    clacks)))



;; REPL Experiments
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_(character-clacks "b")

#_(map character-clacks "bat")

#_(message-clacks "bat" alphabet)

;; strings are not equal to its character
 #_(= "a" \b)



;; Initial design
;; Adds complexity of converting between char and keyword
#_(def alphabet {:a "010001"
                 :b "001010"
                 :t "100111"})

#_(character-clacks :a)



















;; Previous experiments
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; (ns htt-clacks.core
;;   (:require [htt-clacks.clacks-alphabet :refer [alphabet]]))


;; Swap keys and values in a map
;; (def alphabet-inverted (clojure.set/map-invert alphabet))


;; ;; Convert a character to a binary code

;; (defn character->clack [char alphabet]
;;   (let [character (str char)]
;;     (get alphabet character)))

;; (character->clack "a" alphabet)

;; ;; Convert a string to a binary code

;; (defn message->clacks [message alphabet]
;;   (map #(character->clack % alphabet) message))

;; (message->clacks "cab" alphabet)
;; ;; => ([0 1 1 0 0 0 1 1] [0 1 1 0 0 0 0 1] [0 1 1 0 0 0 1 0])

;; (message->clacks "cab cab" alphabet)
;; ;; => ([0 1 1 0 0 0 1 1] [0 1 1 0 0 0 0 1] [0 1 1 0 0 0 1 0] [0 0 0 0 0 0 0 0] [0 1 1 0 0 0 1 1] [0 1 1 0 0 0 0 1] [0 1 1 0 0 0 1 0])

;; ;; Create a charater from a clack code

;; #_(defn clack->character [clack alphabet]
;;   (get (clojure.set/map-invert alphabet) clack))

;; (defn clack->character [clack alphabet]
;;   (get alphabet-inverted clack))

;; ;; Create a clacks code back to a message

;; (defn clacks->message [clacks alphabet]
;;   (reduce str (map #(clack->character % alphabet) clacks)))

;; ;; test data
;; (clacks->message '([0 1 1 0 0 0 1 1] [0 1 1 0 0 0 0 1] [0 1 1 0 0 0 1 0]) alphabet)

;; (clacks->message
;;  '([0 1 1 0 0 0 1 1] [0 1 1 0 0 0 0 1] [0 1 1 0 0 0 1 0] [0 0 0 0 0 0 0 0] [0 1 1 0 0 0 1 1] [0 1 1 0 0 0 0 1] [0 1 1 0 0 0 1 0]) alphabet)

;; ;; (map str ["c" "a" "b"])
;; ;; (reduce str ["c" "a" "b"])
