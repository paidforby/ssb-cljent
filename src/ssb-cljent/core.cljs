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
          (println "message published:"))
    
        (println msg))))

(defn parse_message [msg]
  (print (js->clj msg :keywordize-keys true)))

(defn get_message [sbot]
  (pull (.createFeedStream sbot) 
        (.drain pull parse_message ssb_error)))

(defn sbot_handler [err sbot]
  (let [wss (webSocket.Server. (clj->js {:port "8080"}))]
    (if err
      (println err)
      (println "sbot is running, connection avaliable on port 8080"))

    (defn ws_receive [message] ;; ws handlers must be defn'd in this scope for sbot to work properly
      (def msg {:type "post" :text message})
      ;(pub_message msg sbot)
      (println msg))

    (defn ws_connect [ws]
      (.on ws "message" ws_receive)
      ;(get_message sbot)
      (println "websocket client connected")
      (.send ws "you're connected"))

    (.on wss "connection" ws_connect)))

(defn start [& _]
  (let [ssb (ssbClient sbot_handler)]
  (println "ssb-cljent started!")))

;;(.close ssb)

(set! *main-cli-fn* start)
