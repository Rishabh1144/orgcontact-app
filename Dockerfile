FROM tomcat:9.0-jdk8

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Deploy WAR as ROOT
COPY target/orgcontact.war /usr/local/tomcat/webapps/ROOT.war

# Expose port
EXPOSE 8080

# Start server
CMD ["catalina.sh", "run"]