## Email-service

Install MongoDb Local.
==================
1.CREATE SCHEMA email
2.Create email document
 
Run rabbitmq docker image in detaching mode and export management and application  a ports.
=======================================================================================

docker run -itd -p 5672:5672 -p 15672:15672 rabbitmq:3-management


###  using Gmail SMTP server  we need to create your username and passwrod for this and updte  in application.properties ,  
=====================================================
spring.mail.username=update@gmail.com
spring.mail.password=**********

Also Less secure app access need to enable 

###  Run the main class  In STS 
=====================================
Open EmailserviceApplication RightClick -> Run As->SpringBootApplication or Java Application.

### From command line:
====================
 Run the following command, provided by spring boot plugin.

 gradlew bootRun
 
Note: we are able to see below application Started in Port 8042
      Tomcat started on port(s): 8042 (http) with context path '/bookmyshow-service'
      Url:http://localhost:8042/email-service/


##### gradle clean build
===============

gradlew  clean build


### Running tests in STS
=============================
To run Controller unit Test Open {TODO} RightClick -> Run As-> Junit Test

To run Service unit Test Open {TODO}  RightClick -> Run As-> Junit Test

To run singleServiceTest Open {TODO}  RightClick -> Run As-> Junit Test

To run Cucumber Open {TODO}   RightClick -> Run As-> Junit Test


### Running tests in Gradle
=========================

To run unit and SingleService tests, simply run     gradlew test

To run singleServiceTests,   Need Check and Updtae command .

To run Cucumber  Need Check and Updtae command.


### Application Properties
==========================
Application properties are kept in application.properties.
