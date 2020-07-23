FROM maven:3.5-jdk-8-alpine
RUN mvn install


FROM tomcat:9
EXPOSE 8087
COPY target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]