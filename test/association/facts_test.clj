(ns association.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest cohep-has-spec-basis
  (let [sb (facts/spec-basis "cohep")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "https://") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "HND" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "andi-hnd")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["cohep" "andi-hnd"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["andi-hnd"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "cohep" :governance))))
  (is (empty? (facts/by-topic "cohep" :labor)))
  (is (empty? (facts/by-topic "andi-hnd" :governance))))
