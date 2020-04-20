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

## Local installation:
* Maven 3.3+ (3.6.3)
* Java 8 - 13 (11.0.5)
* IDE (e.g. eclipse with latest version

## Create Project with start.spring.io (Spring Boot fat jar web application)
* Maven project
* Java 11
* Spring Boot 2.1.x
* Group: e.g. de.s&n.spring-boot-demo
* Artifact: e.g. customer
* Dependencies: Web (Srping Boot Web Type), JPA (DB persistance), H2 (In memory DB), Thymeleaf (server side Java template engine, DevTools

## Extract project in local file an build
* Build project with maven: mvn clean install
* Import project in IDE

## Create application details based on imported project
### Create service data model
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

### Create customized hibernate repository
* Create sub package (...).repository
* Create Interface for JPA Controller with paging capabilities (for large db tables)
@Repository
<pre><code>
public interface CustomerRepository  extends PagingAndSortingRepository<CustomerEntity, Long> {
</pre></code>
* Add @Repository annotation before class
* Add method for customized query example for like search:
<pre><code>
@Query("SELECT cus FROM CustomerEntity cus WHERE cus.lastName LIKE %:lastName%")
public List<CustomerEntity> findByLastNameLike(@Param("lastName") String lastName);
</pre></code>

### H2 db preparations
* Add h2 configuration to application.properties (resource folder)
<pre><code>
			spring.datasource.url=jdbc:h2:file:~/test
			spring.datasource.driverClassName=org.h2.Driver
			spring.datasource.username=sa
			spring.datasource.password=
			spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
			 
			# Enabling H2 Console
			spring.h2.console.enabled=true
			 
			# Custom H2 Console URL
			spring.h2.console.path=/h2-console

			#Turn Statistics on and log SQL stmts
			spring.jpa.show-sql=true
			spring.jpa.properties.hibernate.format_sql=true
			 
			#If want to see very extensive logging
			spring.jpa.properties.hibernate.generate_statistics=true
			logging.level.org.hibernate.type=trace
			logging.level.org.hibernate.stat=debug


			#Schema will be created using schema.sql and data.sql files 
			spring.jpa.hibernate.ddl-auto=none
</pre></code>

* Create sql files for schema and record creation (resource folder)
<br> schema.sql
<pre><code>
			DROP TABLE IF EXISTS CUSTOMER;
  
			CREATE TABLE CUSTOMER (
				id INT AUTO_INCREMENT  PRIMARY KEY,
				first_name VARCHAR(255) NOT NULL,
				last_name VARCHAR(255) NOT NULL,
				email VARCHAR(320) DEFAULT NULL
			);
</pre></code>
<br> data.sql
<pre><code>
			INSERT INTO CUSTOMER<br> 
				(first_name, last_name, email)<br> 
			VALUES<br>
				(&#39;Lokesh&#39;, &#39;Gupta&#39;, &#39;abc@gmail.com&#39;),<br>
				(&#39;Deja&#39;, &#39;Vu&#39;, &#39;xyz@email.com&#39;),<br>
				(&#39;Caption&#39;, &#39;America&#39;, &#39;cap@marvel.com&#39;);<br>
</pre></code>

### JUnit Test
* Create repository test in test class <Application_Name>Tests
<pre><code>
		 @Autowired
		 CustomerRepository repository;
		 
		//Test JPA Repository
		@Test
		public void test0testRepositoryFindById() {
				Optional<CustomerEntity> emp = repository.findById(2L);
				assertThat(emp.get().getId(), Matchers.equalTo(2L));
		}		
</pre></code>
*	Start JUNIT Test and check results

### Start application in IDE 
* In IDE: Mark Application class -> run as Java Application
* Or: in IDE: Mark Project and run maven with spring-boot:run 
* Or: console: mvn spring-boot:run 

### Build (create executable Jar File)
* In IDE: Mark Project -> Run as maven install
* I console: mvn package
* Start executable JAR file form project root folder: java -jar target/<application_name>-0.0.1-SNAPSHOT.jar
		
# Links
* [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation)
* [Spring Boot Initalizer (project creation):](https://start.spring.io/)	