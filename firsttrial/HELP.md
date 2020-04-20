# Application FirstTrial

This is an Spring Boot 2 Project for Java 11 and Maven 3.3+ 
The code contains best case approaches for fast project adaption.

Its part of a spring boot tutorial containing follwing chapters
1. Create Spring boot 2 project with H2 database, Data Model, Hibernate Repository
2. Add internal CRUD service with basic test capability
3. Create REST Controller, add error output and error handler, create JUnit test for REST controller
4. Add swagger (OpenAPI) documentation for REST controller
5. Add Spring Boot Actuator with Micrometer Metrics, local Prometheus and Graphana severs and customized health check and furhter enhancements

The current repository contains basic project created by Spring IO with H2 db, Hibernate repository, functional service and JUnit test

# Local installation:
* Maven 3.3+ (3.6.3)
* Java 8 - 13 (11.0.5)
* IDE (e.g. eclipse with latest version

# Create Project with start.spring.io (Spring Boot fat jar web application)
* Maven project
* Java 11
* Spring Boot 2.1.x
* Group: e.g. de.s&n.spring-boot-demo
* Artifact: e.g. customer
* Dependencies: Web (Srping Boot Web Type), JPA (DB persistance), H2 (In memory DB), Thymeleaf (server side Java template engine, DevTools

# Extract project in local file an build
* Build project with maven: mvn clean install
* Import project in IDE

# Create application details based on imported project
1. Create service data model
* Create sub package (...).entity
* Create class (bean) "CustomerEntity" with following attributes:
<br> id: Long
<br> firstName: String (255)
<br> lastName: String (255)
<br> email: String (320)

* Generate Methods
<br> Getter and Setter
<br> (optional) hashCode(): int
<br> (optional) equals(Object): boolean
<br> toString(): String
		
* Add persistance annotations
<pre><code>
			Before public class ...
				@Entity
				@Table(name="CUSTOMER")
			Before id attribute
				@Id
				@GeneratedValue
			Before fristName attribute
				@Column(name="first_name", nullable=false, length=255)
			Same for next attributes
</pre></code>
