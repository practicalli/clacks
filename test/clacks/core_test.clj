(ns clacks.core-test
  (:require [clojure.test :refer :all]
            [clacks.core :refer :all]))

(deftest alphabet-test
  (testing "Test the structure of the alphabet"
    (is (map? alphabet))
    (is (not
         (empty? alphabet))))
  (testing "Test message conversion to Clacks notation"
    (is (= ["001010" "010001" "100111"] (message-clacks "bat" alphabet) )))
  (testing "Test clacks message conversion to English message"
    (is (= "bat" (clacks-message ["001010" "010001" "100111"] alphabet-inverted) ))))



;; Suggestions for Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Test for an alphabet
;; Test encoding of a character
;; Test encoding of a word
;; Test encoding of a whole message
;; Test decoding of a character
;; Test decoding of a word
;; Test decoding of a whole message
