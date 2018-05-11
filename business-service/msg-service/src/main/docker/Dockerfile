FROM java:8
VOLUME /tmp
ADD kaisagroup_msg.jar /kaisagroup_msg.jar
RUN bash -c 'touch /kaisagroup_msg.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_msg.jar"]
EXPOSE 8082