FROM java:8
VOLUME /tmp
ADD kaisagrop_user.jar /kaisagrop_user.jar
RUN bash -c 'touch /kaisagrop_user.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagrop_user.jar"]
EXPOSE 8024