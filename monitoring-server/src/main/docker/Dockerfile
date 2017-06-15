FROM java:8
VOLUME /tmp
ADD monitoring-server.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 6666
