FROM java:8
VOLUME /tmp
ADD kaisagroup_sleuth.jar /kaisagroup_sleuth.jar
RUN bash -c 'touch /kaisagroup_sleuth.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_sleuth.jar"]
EXPOSE 9001