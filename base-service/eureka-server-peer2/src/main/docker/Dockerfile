FROM java:8
VOLUME /tmp
ADD kaisagroup_eureka.jar /kaisagroup_eureka.jar
RUN bash -c 'touch /kaisagroup_eureka.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_eureka.jar"]
EXPOSE 9003
