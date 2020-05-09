# Mcart
In this project I have implemented some features of [Spring Cloud Project](https://spring.io/projects/spring-cloud) for building microservice-based architecture-
* RESTful web services
* Centralized Microservice Configuration with [Spring Cloud Config Server](https://github.com/sanjoliwatts/mcart-config)
* Client side load balancing (Ribbon), Dynamic scaling(Eureka Naming Server) and an API Gateway (Zuul)
* Distributed tracing for microservices with Spring Cloud Sleuth and Zipkin
* Fault Tolerance for microservices with Zipkin

**Note:** Switch to **[Microservices](https://github.com/sanjoliwatts/mcart/tree/microservices)** branch
</br></br>

### Running the Project
* Select Master or Microservices branch for **Monolithic App** and **Microservices** project respectively.
* Download the zip or clone the Git repository.
* Unzip the zip file (if you downloaded one)
* Open Command Prompt and Change directory (cd) to folder containing pom.xml
* Open Eclipse or STS(Spring Tool Suite)
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the right project
* Choose the Spring Boot Application file (search for @SpringBootApplication)
* Right Click on the file and Run as Java Application
</br></br>

###  Built With
* **Maven** - Dependency Management
* **JDK** - Java™ Platform, Standard Edition Development Kit
* **Spring Boot** - Framework to ease the bootstrapping and development of new Spring Applications
* **MySQL** - Open-Source Relational Database Management System
* **git** - Free and Open-Source distributed version control system
* **STS(Spring Tool Suite)** - Easy-to-use integration of the Spring Initializr and the famous Spring Guides
* **Postman** - API Development Environment (Testing API's)
</br></br>

### Packages
`entity`  to hold our entities;</br>
`repositories` — to communicate with the database;</br>
`services` — to hold our business logic;</br>
`utility `— configuration files;</br>
`controllers `— to listen to the client;</br>
`resources/` - Contains all the static resources, templates and property files.</br>
`resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.</br>
`pom.xml` - contains all the project dependencies</br>

