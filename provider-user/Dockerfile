FROM java:8

COPY ./target/classes/application-dev.yml  "/home/tomcat/"
COPY ./target/provider-user-1.0.0-SNAPSHOT.jar  "/home/tomcat/"

CMD ["java", "-jar", "/home/tomcat/provider-user-1.0.0-SNAPSHOT.jar",  "--spring.config.location=/home/tomcat/application-dev.yml"]