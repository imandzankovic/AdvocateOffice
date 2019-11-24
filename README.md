
# AdvocateOffice Application

Advocate Office is application implemented using microservices in Java.

## Technologies

 - Implemented with Spring Boot Framework
 - MySQL used as a database
 - Eureka for synchronous communication between modules
 - RabbitMQ for asynchronous communication between modules 

## Security
 
 Security is implemented with Spring Security.
 Each module uses application settings not locally, but from repository that can be found on:  https://github.com/imandzankovic/CentralConfiguration
 

## Usage

After login, user can manage his meetings (schedule new ones, update existing), hearings, TO DO task list  and cases.




