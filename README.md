# ssb-cljent
an ssb-client in clojure

This is (right now) just an example of how to interface with sbot from clojurescript. I'm assuming you already have a working sbot and proper ssb keys. The easiest way to get started with ssb is by installing [patchwork](https://github.com/ssbc/patchwork/releases).

## build and run example 

The are a few ways to compile clojure to node.js, Two ways we've tested are using the cljs.jar found [here](https://github.com/clojure/clojurescript/releases/tag/r1.9.946) or using [leiningen-figwheel-node](https://github.com/malyn/figwheel-node-template).  

Start by cloning this repo, `git clone https://github.com/paidforby/ssb-cljent`

In a separate terminal, start sbot by running, `sbot server`.  

If using jar:
* copy cljs.jar into the ssb-cljent directory
* `cd ssb-cljent`
* `java -cp cljs.jar:src clojure.main build.clj` 
* node main.js

If using leinigen:
* `cd ssb-cljent`
* `npm install`
* `lein figwheel`
* in another terminal run `node <ssb-cljient-dir>/target/js/compiled/ssb_cljent.js`

You should receive some debugging output. Amongst a bunch of hashes, you should see the message you published, `:content #js {:type post, :text first clojurey post}`. You may also open your preferred gui ssb-client and observe the message you just posted.

## TODO 
* auto recompile with lein and watchify the node script
* testing and debugging with [ssb-minial](https://github.com/av8ta/ssb-minimal)
* port pull-stream examples from [scuttlebot](https://www.npmjs.com/package/scuttlebot)
