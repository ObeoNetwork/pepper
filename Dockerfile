FROM eclipse-temurin:17-jre-alpine-3.20
RUN adduser --disabled-password pepperuser
COPY ./backend/pepper-application/target/pepper-application.jar /opt/app/pepper-application.jar

EXPOSE 8080
USER pepperuser
CMD ["java", "-jar", "/opt/app/pepper-application.jar"]