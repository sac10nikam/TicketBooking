## TicketProvider-service

Install Mysql Local.
==================
1.CREATE SCHEMA ticketprovider
2.Create ticketprovider TABLE.

 1.CREATE TABLE `ticketprovider`.`ticket` (
  `TicketId` INT NULL,
  `MovieId` INT NULL,
  `TheaterId` INT NULL,
  `NumberOfTickets` INT NULL,
  `Price` INT NULL,
  `TicketConsumerType` VARCHAR(45) NULL,
  PRIMARY KEY (`TicketId`));
  
2. ALTER TABLE ticketprovider.ticket MODIFY COLUMN TicketId INT auto_increment

Run rabbitmq docker image in detaching mode and export management and application  a ports.
=======================================================================================

docker run -itd -p 5672:5672 -p 15672:15672 rabbitmq:3-management

###  Run the main class  In STS 
=====================================
Open BookMyshowServiceApplication RightClick -> Run As->SpringBootApplication or Java Application.

### From command line:
====================
 Run the following command, provided by spring boot plugin.

 gradlew bootRun
 
Note: we are able to see below application Started in Port 8040 
      Tomcat started on port(s): 8041 (http) with context path '/ticketprovider-service'
      Url:http://localhost:8041/ticketprovider-service/


##### gradle clean build
===============

gradlew  clean build


### Running tests in STS
=============================
To run Controller unit Test Open TicketControllerTest RightClick -> Run As-> Junit Test

To run Service unit Test Open TicketServiceTest RightClick -> Run As-> Junit Test

To run singleServiceTest Open TicketProviderSingleServiceApplicationTests RightClick -> Run As-> Junit Test

To run Cucumber Open FunctionalSpringTestRunner  RightClick -> Run As-> Junit Test


### Running tests in Gradle
=========================

To run unit and SingleService tests, simply run     gradlew test

To run singleServiceTests,   Need Check and Updtae command .

To run Cucumber  Need Check and Updtae command.


### Application Properties
==========================
Application properties are kept in application.properties.
