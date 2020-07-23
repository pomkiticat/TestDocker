FROM maven:3.5-jdk-8-alpine
COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
RUN mvn -f /home/app/pom.xml install
#RUN mvn install


FROM tomcat:9
EXPOSE 8087
#COPY --from=build /home/app/target/*.war /usr/local/tomcat/webapps/
COPY /home/app/target/*.war /usr/local/tomcat/webapps/
#COPY target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]