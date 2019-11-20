FROM tomcat:8.0.20-jre8
MAINTAINER nileshsingh067@gmail.com|Nilesh Singh
COPY ./thebooklender/target/thebooklender.war /usr/local/tomcat/webapps/thebooklender.war

EXPOSE 8080
