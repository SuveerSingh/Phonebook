# Phonebook Application Intro

This is my submission to the Phonebook Application technical challenge. 

The application follows the Client/Server architecture model. 

Ideally the API should sit behind a Gateway with a secure authentication model : client-id/client-secret | mutual tls | openid connect | basic auth etc. I have excluded this from my design as this requires a standalone/centrally deployed mechanism where all APIs are deployed to. 

The application has been broken down into the following components : 

# Web Interface

Technology/Framework : Angular

### Workflow :

Technology/Framework : Angular 8



# API

Technology/Framework : Springboot - Java 8

Database : PostgreSQL

ORM : CrudRepository

Design Patter : Dependency Injection | Data Driven Design

Testing Framework : Mockito

Migration Script Handler : Flyway

OS Version : macOS Catalina Version 10.15

Docuementation : Swagger (http://localhost:8080/swagger-ui.html)

### Installing : 

[1] Ensure Maven is installed : https://maven.apache.org/install.html

[2] Clean install with maven: mvn clean install

[3] Install PostgreSQL : https://www.postgresql.org/download/

[4] Create a database called "Phonebook_db" in PostgreSQL

### Workflow : 

[1] The API exposes 1 controller : PhonebookController 

[2] All endpoints validate the client-id being passed through from the web interface. The idea behind this is that this key is generated by the API Gateway and is passed through from the web interface through to the gateway and finally onto the API. 

[3] Each endpoint performs basic validation on the request body eg. not null, length. This implementation has been abstracted into a utilities class to contain these rules making easily extendable/maintainable as and when business requirements change or evolve.

[4] Post validation of the request and client-id, the request is then passed onto a service manager, which has also been abstracted and exposed as an interface.

[5] Once the service manager has received the request, the request is then passed into the data service nanager, which then creates the final layer of abstraction within the api. Creating these layers of abstraction also allows to have cleaner testable code without heavy dependencies amongst classes.

[6] The data layer has been written independently and does not require PostgreSQL in specific to function. Utilising the JDBC underlying framework allows us to use any of the following databases : Oracle, MySQL, DB2, SQL Server. The migration scripts however are specific to PostgreSQL in terms of syntax. 

[7] The choice of a PostgreSQL database was purely due to it being open source. Its very easy to learn and manages relational databases. 

[8] I have utilised Mockito as my testing framework as classes can be easily mocked and is a fairly lightweight framework to use.






