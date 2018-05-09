FROM java:8
VOLUME /tmp
ADD kaisagroup_conf.jar /kaisagroup_conf.jar
RUN bash -c 'touch /kaisagroup_conf.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_conf.jar"]
EXPOSE 9004