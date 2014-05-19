##demo-restWS-spring-jersey-tomcat-mybatis

### Install and run the project
==
#### Prerequisites:
* MySQL 5.5 or 5.6 
* Eclipse (or any other IDE you feel comfortable with)
* JDK 1.7 (if you want to use Jetty 9 with the jetty-maven-plugin from project)

#### Create DB schema
Create db schema by running the [MySql single file script](https://github.com/amacoder/demo-restWS-spring-jersey-tomcat-mybatis/blob/master/src/main/resources/input_data/DumpRESTdemoDB.sql) script against the MySQL database (user/pwd - rest_demo/rest_demo)

### Run the example
--
- Download/clone the project 
- Import in Eclipse 
- Run Configuration -> Goals `clean install jetty:run`

### Blog post on [Codingpedia.org](http://www.codingpedia.org)
[RESTful Web Services Example in Java with Jersey, Spring and MyBatis](http://www.codingpedia.org/ama/restful-web-services-example-in-java-with-jersey-spring-and-mybatis/)
You will find there detailed explanation of the code
#### Related posts
* [How to add CORS support on the server side in Java with Jersey](http://www.codingpedia.org/ama/how-to-add-cors-support-on-the-server-side-in-java-with-jersey/) 
* [Java Persistence Example with Spring, JPA2 and Hibernate](http://www.codingpedia.org/ama/how-to-use-gulp-to-generate-css-from-sass-scss/) - DB access via JPA/Hibernate implementation for the same project

### License
==
Copyright (c) 2014 Codingpedia Association. See the LICENSE file for license rights and limitations (MIT).
