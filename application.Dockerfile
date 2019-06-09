FROM openjdk:8
ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-jar", "demo-0.0.1-SNAPSHOT.jar", "container-entrypoint"]
EXPOSE 8000
