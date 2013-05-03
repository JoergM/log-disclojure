(ns log-disclojure.core)

(defn from-file [path]
  (clojure.string/split-lines (slurp path)))

(defn parse-to-event [raw-event]
  {:timestamp (subs raw-event 0 23)
    :content (subs raw-event 24)})

(defn load-events [path]
  (map parse-to-event (from-file path)))