# Phonebook Application Intro

This is my submission to the Phonebook Application technical challenge. 

The application follows the Client/Server architecture model. 

Ideally the API should sit behind a Gateway with a secure authentication model : client-id/client-secret | mutual tls | openid connect | basic auth etc. I have excluded this from my design as this requires a standalone/centrally deployed mechanism where all APIs are deployed to. 

The application has been broken down into the following components : 

# Web Interface

I have decided to utilise a template that ive used before, which allowed me to reuse components and not rebuild components from scratch.

Technology/Framework : Angular

Template : https://www.creative-tim.com/

Licence Type : Developer

OS Version : Tested in Google Chrome Version 78.0.3904.87 (Official Build) (64-bit) on macOS Catalina Version 10.15

### Installing : 

[1] Run npm install

[2] Run ng serve : http://localhost:4200

[3] Ensure server(API) is running

### Workflow :

[1] I have excluded an OAuth provider from the implementation. The UI however does cater for this concept graphically.

[2] The landing page displays the functionality of the application.

[3] Phonebook Managements is a central location for managing phonebooks.

[4] Phonebook Entry Management provides the functionality of managing entries within a phonebook.

[5] I did include the concept of categories with the intention of being able to create different types of phonebooks | Personal, Business etc. In the essence of time i have decided to exclude this.

[6] All requests to the api are performed utilising JSON/HTTP.

[7] A client id has been embended into the application. This will ideally differ per environment and injected via a CI/CD pipeline

# API

Technology/Framework : Springboot - Java 8

Database : PostgreSQL

ORM : CrudRepository

Design Pattern : Dependency Injection | Data Driven Design

Testing Framework : Mockito

Migration Script Handler : Flyway

OS Version : macOS Catalina Version 10.15

Docuementation : Swagger (http://localhost:8080/swagger-ui.html)

### Installing : 

[1] Ensure Maven is installed : https://maven.apache.org/install.html

[2] Clean install with maven: mvn clean install

[3] Install PostgreSQL : https://www.postgresql.org/download/

[4] Create a database called "Phonebook_db" in PostgreSQL

[5] The api will recreate the database everytime the application is running. This can be changed in the application.properties file by changing this line : "spring.jpa.hibernate.ddl-auto=create" to "spring.jpa.hibernate.ddl-auto=none"

This does however require the database named "Phonebook_db" to be created. I have excluded the creation of the db in the script.
Scripts are only executed against the db once. To re-run the scripts -> delete all tables from Postgres, rebuild the application and run. 

### Workflow : 

[1] The API exposes 2 controllers : PhonebookController | Actuator

[2] All endpoints validate the client-id being passed through from the web interface. The idea behind this is that this key is generated by the API Gateway and is passed through from the web interface through to the gateway and finally onto the API. 

[3] Each endpoint performs basic validation on the request body eg. not null, length. This implementation has been abstracted into a utilities class to contain these rules making easily extendable/maintainable as and when business requirements change or evolve.

[4] Post validation of the request and client-id, the request is then passed onto a service manager, which has also been abstracted and exposed as an interface.

[5] Once the service manager has received the request, the request is then passed into the data service nanager, which then creates the final layer of abstraction within the api. Creating these layers of abstraction also allows to have cleaner testable code without heavy dependencies amongst classes.

[6] The data layer has been written independently and does not require PostgreSQL in specific to function. Utilising the JDBC underlying framework allows us to use any of the following databases : Oracle, MySQL, DB2, SQL Server. The migration scripts however are specific to PostgreSQL in terms of syntax. 

[7] The choice of a PostgreSQL database was purely due to it being open source. Its very easy to learn and manages relational databases. 

[8] I have utilised Mockito as my testing framework as classes can be easily mocked and is a fairly lightweight framework to use.

[9] The Actuator endpoint is used purely for healthchecks and is available on the ffg endpoint : http://localhost:8080/actuator/info






