FROM java:8
VOLUME /tmp
ADD ./target/kaisagroup_admin.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9002
ENTRYPOINT ["java","-jar","/app.jar"]