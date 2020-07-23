FROM tomcat:9
EXPOSE 8087
RUN mvn install
COPY target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]