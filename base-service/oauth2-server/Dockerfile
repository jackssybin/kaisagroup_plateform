FROM java:8
VOLUME /tmp
ADD ./target/kaisagroup_oauth2.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9006
ENTRYPOINT ["java","-jar","/app.jar"]