#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#ADD /target/demo-spring-0.0.1-SNAPSHOT.jar demo-spring-0.0.1-SNAPSHOT.jar
#
#CMD ["java", "-jar", "demo-spring-0.0.1-SNAPSHOT.jar"]
FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demospring.DemoSpringApplication"]