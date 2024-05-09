FROM openjdk:17
WORKDIR /app
VOLUME ["/app"]
COPY maven/testtask-3.2.5.jar app.jar
COPY maven/start.sh start.sh
RUN sh -c 'touch app.jar'
ENTRYPOINT ["sh", "./start.sh"]