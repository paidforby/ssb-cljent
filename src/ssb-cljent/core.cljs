(ns ssb-cljent.core
  (:require left-pad ))
;; just including left-pad to demo another way of requiring node modules

(enable-console-print!)

(def pull (js/require "pull-stream"))
(def ssbClient (js/require "ssb-client"))
(def webSocket (js/require "ws"))
(def test_message {:type "post" :text "first clojurey post"})

(defn ssb_error [err]
  (if err
    (println err)
    (println "message received")))

(defn pub_message [message sbot]
    (.publish sbot (clj->js message) 
      (fn [err msg] 
        (if err
          (println err)
          (println "no err"))
    
        (println msg))))

(defn parse_message [msg]
  (print (js->clj msg :keywordize-keys true)))

(defn get_message [sbot]
  (pull (.createFeedStream sbot) 
        (.drain pull parse_message ssb_error)))

(defn sbot_callback [err sbot]
    (if err
      (println err)
      (println "no error"))

    ;(pub_message test_message sbot)
    ;(get_message sbot)
    )

(defn ws_receive [message]
  (println message))

(defn ws_connect [ws]
  (println "websocket client connected")
  (.on ws "message" ws_receive)
  (.send ws "something"))

(def wss (webSocket.Server. (clj->js {:port "8080"})))

(.on wss "connection" ws_connect)

(def ssb (ssbClient sbot_callback))
;;(.close ssb)

;; pad the number 42 with five zeros
(println (left-pad 42 5 0))
