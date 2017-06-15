FROM java:8
VOLUME /tmp
ADD user-consumer-feign.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 80
