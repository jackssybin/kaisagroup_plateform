FROM java:8
VOLUME /tmp
ADD kaisagroup_zuul.jar /kaisagroup_zuul.jar
RUN bash -c 'touch /kaisagroup_zuul.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_zuul.jar"]
EXPOSE 9005