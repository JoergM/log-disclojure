(ns log-disclojure.core-test
  (:use clojure.test
        log-disclojure.core))

(deftest datei-einlesen
  (testing "Datei wird eingelesen und gesliced"
    (is (= (count (from-file "data/log.out")) 20))))

(deftest datei-einlesen-und-parsen
  (testing "Datei wird eingelesen und geparsed"
    (is (= (load-events "data/log.out") (read-string (slurp "data/log-result.clj"))))))

(deftest parse-to-event-test
  (is (= (parse-to-event "2013-05-03 13:30:17,955 INFO  myApp-2013.05.03.12.27.49")
        {:timestamp "2013-05-03 13:30:17,955" :content "INFO  myApp-2013.05.03.12.27.49"})))

;; Gesamtrahmen
;; Liste von Dateinen eingeben und eine Sequenz von Events ausgeben,
;; wobei ein Event aus Datum und Rest besteht

(comment

(deftest integration
  (main "data/log1.out" "data/log2.out"))

)

(run-tests)