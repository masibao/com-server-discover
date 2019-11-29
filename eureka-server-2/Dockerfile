FROM java:8

COPY ./target/classes/application.yml  "/home/tomcat/"
COPY ./target/classes/application-dev.yml  "/home/tomcat/"
COPY ./target/classes/application-prd.yml  "/home/tomcat/"
COPY ./target/eureka-server-2-1.0.0-SNAPSHOT.jar  "/home/tomcat/"

CMD ["java", "-jar", "/home/tomcat/eureka-server-2-1.0.0-SNAPSHOT.jar",  "--spring.config.location=/home/tomcat/application.yml"]
