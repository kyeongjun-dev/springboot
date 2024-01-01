FROM openjdk:17
WORKDIR /app
COPY demo.jar demo.jar
COPY opentelemetry-javaagent.jar opentelemetry-javaagent.jar
CMD ["java", "-javaagent:opentelemetry-javaagent.jar", "-Dotel.javaagent.debug=true","-jar", "demo.jar"]