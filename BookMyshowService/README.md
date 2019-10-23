## Bookmyshow-service

Install Mysql Local.
==================
1.CREATE SCHEMA bms

.Create below tables in schema.
=====================

  CREATE TABLE `bms.`address` (
  `adressid` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `pinCode` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adressid`);
 
 ALTER TABLE bms.ticket MODIFY COLUMN adressid INT auto_increment
 
 
 CREATE TABLE `booking` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `MovieId` int(11) NOT NULL,
  `TheaterId` int(11) NOT NULL,
  `PaymentId` int(11) DEFAULT NULL,
  `movie_timing` time DEFAULT NULL,
  `booked_date` date DEFAULT NULL,
  `bookedSeats` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookingId`)
)
 
  ALTER TABLE bms.booking MODIFY COLUMN bookingId INT auto_increment
 
 
 CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL DEFAULT '0',
  `movieName` char(50) DEFAULT NULL,
  `movieType` char(50) DEFAULT NULL,
  PRIMARY KEY (`movieId`))
 
   ALTER TABLE bms.movie MODIFY COLUMN movieId INT auto_increment
 
 CREATE TABLE `payment` (
  `Paymentid` int(11) NOT NULL AUTO_INCREMENT,
  `Paymennttype` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `status_of_payment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Paymentid`)
)
 ALTER TABLE bms.payment MODIFY COLUMN Paymentid INT auto_increment
 
 
CREATE TABLE `theater` (
  `theaterName` varchar(45) DEFAULT NULL,
  `adressId` int(11) DEFAULT NULL,
  `theaterId` int(11) DEFAULT NULL,
  `screen` varchar(45) DEFAULT NULL,
  `seats` varchar(45) DEFAULT NULL,
  `movieId` int(11) DEFAULT NULL,
  PRIMARY KEY `theaterid` (`theaterId`)
) 

 
 ALTER TABLE bms.theater MODIFY COLUMN theaterId INT auto_increment
 
 CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TicketId` int(11) NOT NULL,
  `MovieId` int(11) NOT NULL,
  `TheaterId` int(11) NOT NULL,
  `NumberOfTickets` int(11) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
 
  ALTER TABLE bms.ticket MODIFY COLUMN id INT auto_increment
  
  CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `mobNo` varchar(45) DEFAULT NULL,
  `emailId` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) 
  
   ALTER TABLE bms.user MODIFY COLUMN userId INT auto_increment

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
 
Note: we are able to see below application Started in Port 8041
      Tomcat started on port(s): 8041 (http) with context path '/bookmyshow-service'
      Url:http://localhost:8041/bookmyshow-service/


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
