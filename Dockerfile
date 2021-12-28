FROM maven:3.8.1 as craft
COPY src /home/app/tenpo/src
COPY pom.xml /home/app/tenpo
RUN mvn -f /home/app/tenpo/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=craft /home/app/tenpo/target/*.jar /usr/local/lib/tenpo.jar
CMD ["java", "-jar", "/usr/local/lib/tenpo.jar"]