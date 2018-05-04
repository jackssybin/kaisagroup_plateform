FROM java:8
VOLUME /tmp
ADD ./target/kaisagroup_msg.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]