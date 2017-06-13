FROM java:8
VOLUME /tmp
ADD config-server.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8888
