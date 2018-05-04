FROM java:8
VOLUME /tmp
ADD ./target/kaisagroup_eureka.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9003
ENTRYPOINT ["java","-jar","/app.jar"]