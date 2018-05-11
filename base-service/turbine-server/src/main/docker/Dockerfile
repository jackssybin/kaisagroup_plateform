FROM java:8
VOLUME /tmp
ADD kaisagroup_turbine.jar /kaisagroup_turbine.jar
RUN bash -c 'touch /kaisagroup_turbine.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kaisagroup_turbine.jar"]
EXPOSE 9002