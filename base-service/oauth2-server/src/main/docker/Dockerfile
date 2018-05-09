FROM java:8
VOLUME /tmp
ADD kaisagroup_oauth2.jar /kaisagroup_oauth2.jar
RUN bash -c 'touch /kaisagroup_oauth2.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_oauth2.jar"]
EXPOSE 9006