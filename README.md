# ssb-cljent
an ssb-client in clojure

This is (right now) just an example of how to interface with sbot from clojurescript. I'm assuming you already have a working sbot and proper ssb keys. The easiest way to get started with ssb is by installing [patchwork](https://github.com/ssbc/patchwork/releases).

## build and run example 

The are a few ways to compile clojure to node.js, I used the cljs.jar found [here](https://github.com/clojure/clojurescript/releases/tag/r1.9.946). You could also try using leiningen/figwheel.  

Start by cloning this repo, `git clone https://github.com/paidforby/ssb-cljent`

If using jar:
* copy cljs.jar into the ssb-cljent directory
* `cd ssb-cljent`
* `java -cp cljs.jar:src clojure.main build.clj` 

If using leinigen:
* TODO add leiningen instructions...

In a separate terminal, start sbot by running, `sbot server`.  

Back in the ssb-cljent directory run, `node main.js`

You should receive some debugging output. Amongst a bunch of hashes, you should see the message you published, `:content #js {:type post, :text first clojurey post}`. You may also open your preffered gui ssb-client and observe the message you just posted.

## TODO 
* a good way of testing and debugging?
* port pull-stream examples from [scuttlebot](https://www.npmjs.com/package/scuttlebot)
