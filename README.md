# ssb-cljent
an ssb-client in clojure

This is (right now) just an example of how to interface with sbot from clojurescript. I'm assuming you already have a working sbot and proper ssb keys. The easiest way to get started with ssb is by installing [patchwork](https://github.com/ssbc/patchwork/releases).

## build and run example 

The are a few ways to compile clojure to node.js, Two ways we've tested are using the cljs.jar found [here](https://github.com/clojure/clojurescript/releases/tag/r1.9.946) or using [leiningen-figwheel-node](https://github.com/malyn/figwheel-node-template).  

Start by cloning this repo, `git clone https://github.com/paidforby/ssb-cljent`

In a separate terminal, start sbot by running, `sbot server` (NOTE: this uses the default ssb network, for development, see [running testnet](https://github.com/paidforby/ssb-cljent#running-testnet))

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
* To auto rebuild, once in the leinREPL type `(start-autobuild "dev")`, this will also re-run the node script.

You should receive some debugging output. Amongst a bunch of hashes, you should see the message you published, `:content #js {:type post, :text first clojurey post}`. You may also open your preferred gui ssb-client and observe the message you just posted.

## running testnet
Once you have sbot installed, connecting to a testnet is not fairly simple. Instead of running `sbot server` which uses the default shs and sign keys, typically stored in the $HOME/.ssb/config, you manually set the keys by running,  
```
sbot server -- --caps.shs="GVZDyNf1TrZuGv3W5Dpef0vaITW1UqOUO3aWLNBp+7A=" --caps.sign="gym3eJKBjm0E0OIjuh3O1VX8+lLVSGV2p5UzrMStHTs="
```
WARNING: it is very likely you will fork your feed using the above command, we are working on a virtualized solution for building a testnet.     

Vagrantfile currently builds a debian/stretch64 vm and installs node.js and npm; however, attempting to install scuttlebot produces [issue #1](https://github.com/paidforby/ssb-cljent/issues/1).

The values of caps.shs and caps.sign are not important as long as they are valid hashes and are not the same as the default (or someone else's testnet?). The client must also reference the same keys in order to successful connect to this instance of sbot (i.e. if you try to run `sbot createLogStream` in your shell without also passing the same keys, it will fail to find the sbot server)   

## TODO
* add config opts to ssbClient code a la [ssb-minial](https://github.com/av8ta/ssb-minimal/blob/master/index.js)
* functionally parse pull-stream from [scuttlebot](https://www.npmjs.com/package/scuttlebot)
