FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY pom.xml /app/
#RUN cd /app/ && mvn package
#RUN mvn install
#RUN mvn -f /app/pom.xml clean package
RUN ["mvn", "package"]

#
#FROM postgres:latest
#ENV POSTGRES_USER postgres
#ENV POSTGRES_PASSWORD 123qwe
#ENV POSTGRES_DB gtma




FROM tomcat:9
EXPOSE 8087
#COPY --from=build /home/app/target/*.war /usr/local/tomcat/webapps/
COPY /app/target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]