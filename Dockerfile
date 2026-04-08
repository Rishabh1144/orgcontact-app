FROM tomcat:10.1-jdk21

COPY target/orgcontact.war /usr/local/tomcat/webapps/

EXPOSE 8080