(require 'cljs.build.api)

(cljs.build.api/build "src"
  {:optimizations :none
   :main 'ssb-example.core
   :npm-deps {:left-pad "1.1.3"
              :scuttlebot "10.4.10"} 
   :install-deps true 
   :output-to "main.js"
   :target :nodejs})
