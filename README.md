demo-restWS-spring-jersey-tomcat-mybatis
========================================

Prerequisites:
--
- MySQL 5.5 or 5.6 
- Eclipse
- JDK 1.7 (if you want to use Jetty 9 with the jetty-maven-plugin from project)

Install
--
Create db schema by running the https://github.com/amacoder/demo-restWS-spring-jersey-tomcat-mybatis/blob/master/src/main/resources/input_data/DumpRESTdemoDB.sql script against the MySQL database (user/pwd - rest_demo/rest_demo)

Run the example
--
- Download/clone the project 
- Import in Eclipse 
- Run Configuration -> Goals "clean install jetty:run"

Go to blog post
--

Visit http://www.codingpedia.org/ama/restful-web-services-example-in-java-with-jersey-spring-and-mybatis/ for the explanation of the code
