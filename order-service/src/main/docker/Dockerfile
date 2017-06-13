FROM java:8
VOLUME /tmp
ADD order-service.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9999
