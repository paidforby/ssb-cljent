#!/bin/bash

sbot server & #-- --caps.shs="GVZDyNf1TrZuGv3W5Dpef0vaITW1UqOUO3aWLNBp+7A=" --caps.sign="gym3eJKBjm0E0OIjuh3O1VX8+lLVSGV2p5UzrMStHTs="
sbot_pid=$!

sbot plugins.install ssb-about
sbot plugins.enable ssb-about

sbot plugins.install ssb-backlinks
sbot plugins.enable ssb-backlinks

sbot plugins.install ssb-fulltext
sbot plugins.enable ssb-fulltext

kill $sbot_pid

cp -r /usr/local/ssb-cljent/ssb/* /root/.ssb/.

sbot server #-- --caps.shs="GVZDyNf1TrZuGv3W5Dpef0vaITW1UqOUO3aWLNBp+7A=" --caps.sign="gym3eJKBjm0E0OIjuh3O1VX8+lLVSGV2p5UzrMStHTs="
