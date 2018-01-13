# specify the node base image with your desired version node:<version>
FROM node:7
RUN npm config set user 0
RUN npm config set unsafe-perm true
RUN npm --loglevel=warn install -g scuttlebot@10.4.6
EXPOSE 8007
ENV SSB_DIR /usr/local/ssb-cljent
WORKDIR $SSB_DIR
COPY . $SSB_DIR 
ENTRYPOINT ["./entrypoint.sh"]
