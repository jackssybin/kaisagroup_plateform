FROM java:8
VOLUME /tmp
ADD kaisagroup_admin.jar /kaisagroup_admin.jar
RUN bash -c 'touch /kaisagroup_admin.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_admin.jar"]
EXPOSE 9002