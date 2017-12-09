(ns ssb-example.core
  (:require left-pad))
;; just including left-pad to demo another way of requiring node modules

(enable-console-print!)

(def ssbClient (js/require "ssb-client"))
(def message {:type "post" :text "first clojurey post"})
;; this should be done with a let? 

(defn clj->json
  [ds]
  (.stringify js/JSON (clj->js ds)))

(ssbClient (fn [err sbot]
    (if err
      (println err)
      (println "no err"))

    ;;(let [message ({:type "post" :text "first clojurey post"})])
    (println message)
    (println (clj->js message))

    (.publish sbot (clj->js message) (fn [err msg] 
      (if err
        (println err)
        (println "no err"))

      (println msg)))

    (println "in scuttlebuts")))

;; pad the number 42 with five zeros
(println (left-pad 42 5 0))
