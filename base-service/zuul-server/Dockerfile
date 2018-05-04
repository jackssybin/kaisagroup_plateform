FROM java:8
VOLUME /tmp
ADD ./target/kaisagroup_zuul.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9005
ENTRYPOINT ["java","-jar","/app.jar"]