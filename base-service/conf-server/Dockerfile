FROM java:8
VOLUME /tmp
ADD ./target/kaisagroup_conf.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9004
ENTRYPOINT ["java","-jar","/app.jar"]