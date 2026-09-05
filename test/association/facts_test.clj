(ns association.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is testing]]
            [association.facts :as facts]))

(def ^:private entries (facts/spec-basis "cohep"))

(deftest cohep-has-spec-basis
  (is (= 14 (count entries)))
  (is (every? #(str/starts-with? (:association-rule/url %) "https://") entries))
  (is (every? #(= "9411" (:association-rule/isic %)) entries))
  (is (every? #(= "HND" (:association-rule/country %)) entries)))

(deftest every-entry-is-individually-identified-and-cited
  ;; A catalog whose ids collide silently loses an entry the moment anything
  ;; indexes it by id; a catalog that reuses one url for everything is one
  ;; citation wearing fourteen hats.
  (is (= (count entries) (count (distinct (map :association-rule/id entries)))))
  (is (every? #(str/starts-with? (:association-rule/id %) "cohep.") entries))
  (is (every? :association-rule/retrieved-at entries))
  (is (every? :association-rule/title entries))
  (is (every? #(seq (:association-rule/topic %)) entries))
  (is (< 1 (count (distinct (map :association-rule/url entries))))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "andi-hnd")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["cohep" "andi-hnd"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["andi-hnd"] (:missing-associations c)))))

(deftest the-note-counts-what-the-catalog-actually-holds
  ;; The note is computed, so it moves when the catalog does. Asserting the
  ;; number rather than the sentence keeps this from being a spellcheck.
  (let [note (facts/note-for "cohep")]
    (is (str/includes? note (str (count entries) " COHEP entries")))
    (is (str/includes? note "contradicted by another page"))))

(deftest the-two-dates-for-resolution-99-are-both-kept
  ;; COHEP's statutes page dates Executive Resolution 99 to 5 May 1967 and its
  ;; membership page dates the same resolution to 8 May 1967. Recording one and
  ;; dropping the other would look tidier and would be a fabricated agreement.
  (let [by-id (into {} (map (juxt :association-rule/id identity) entries))
        stat  (by-id "cohep.estatutos-art-1-resolution-99")
        conf  (by-id "cohep.afiliacion-resolution-99-conflicting-date")]
    (is (= "1967-05-05" (:association-rule/established-date stat)))
    (is (= "1967-05-08" (:association-rule/established-date conf)))
    (is (not= (:association-rule/url stat) (:association-rule/url conf))
        "the disagreement is only evidence if the two pages are cited separately")
    (is (= :official-cohep-org-conflicting (:association-rule/url-provenance conf))
        "and the conflicting page must not be filed as a clean official citation")))

(deftest by-topic-filters
  (doseq [[topic n] {:governance 9 :ethics 6 :membership 2 :enforcement 1 :labor 1}]
    (testing (name topic)
      (is (= n (count (facts/by-topic "cohep" topic))))))
  (is (empty? (facts/by-topic "cohep" :no-such-topic)))
  (is (empty? (facts/by-topic "andi-hnd" :governance))))
