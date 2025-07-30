FROM tomcat:10.1-jdk17
LABEL authors="slavs"

WORKDIR /usr/local/tomcat/webapps
ADD target/mvn4-1.1-SNAPSHOT.war .

CMD ["catalina.sh", "run"]