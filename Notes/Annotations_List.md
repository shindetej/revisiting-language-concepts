### LIST OF ANNOTATIONS WITH USAGE MEANING
#### Interview question :  What annotations do you used in your project? / tell me annotations in spring boot
1. we wiil start with @SpringBootApplication annotation which is entry point of a Spring Boot application having internally three main annotations
2.  @Configuration  : Class marked as source of bean definitions
3.  @EnableAutoConfiguration : enables spring boots auto configuration feature  
4.  @ComponentScan :  scanning of Spring components within package and sub packages
5.  @Component : 
6. @Bean - used to define a bean in a Spring configuration class.  tells Spring that the annotated method will return an object that should be registered as a bean in the Spring ApplicationContext. 
4. @Autowired - 
  -  used to automatically inject dependencies into Spring beans.
  -  applied to a field, setter, or constructor
  -  reduces the need for explicit bean management
7. @Component  : It is a generic stereotype annotation used to mark a class as a Spring bean
8. @Controller : specialized version of @Component used to mark a class as a Spring MVC controller /responsible for handling HTTP requests. 
9. @Service    : specialization of @Component used to mark a class as a service in the service layer of an application.
10. @Repository :  specialization of @Component that marks a class as a Data Access Object (DAO) in the persistence layer

---- Controller based annotations ---

-  @RestController: A combination of @Controller and @ResponseBody used for RESTful web services; it eliminates the need to annotate each method with @ResponseBody.
- @RequestMapping: Maps HTTP requests to handler methods of MVC and REST controllers. You can specify the URL, method type (GET, POST, etc.), and other parameters.
- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Shortcut annotations for mapping HTTP GET, POST, PUT, DELETE requests to handler methods.

--- JPA Methods ----------------

- @Repository: Marks a class as a Data Access Object (DAO). It also indicates that any exceptions thrown should be translated into Spring’s DataAccessException.
- @Entity: Marks a class as a JPA entity, mapping it to a database table.
- @Table: Specifies the table name in the database that the entity is mapped to.
- @Id: Denotes the primary key of an entity.
- @GeneratedValue: Automatically generates values for primary keys.
- @Column: Specifies the details of a column mapped to a field in the entity class.
- @ManyToOne, @OneToMany, @OneToOne, @ManyToMany: These are JPA annotations to define relationships between entities.
- @Transactional: Used to manage transactions in Spring, either at the class or method level.

--- Exception Handling Annotations -----

- @ExceptionHandler: Handles specific exceptions thrown by methods in a controller. You can use it to send custom error responses or perform additional logging.
- @ResponseStatus: Allows you to define a specific HTTP status code for a method or exception class.
- @ControllerAdvice: Provides global exception handling across all controllers. It's typically used for handling application-wide exceptions and applying common behaviors for error handling.

---- Other Important Annotations ----
- @Value: Used to inject values into fields from property files or environment variables.
- @Profile: Defines beans that are only available in specific profiles. It’s useful for environment-specific configuration.
- @Scope: Defines the scope of a bean (e.g., singleton, prototype, request, session).
- @Async: Marks a method for asynchronous execution.
- @Cacheable: Marks a method to have its result cached. It is useful in performance optimization by storing the result of expensive method calls.
- @EnableCaching: Enables caching within a Spring application. It is typically used on configuration classes.
- @EnableScheduling: Enables Spring’s scheduled task execution capability.

- Spring configurations and bean creation
    1. @Configuration
    2. @Bean
    3. @Autowired
-------------------------
- Lifecycle related
    1. @PostConstruct
    2. @PreDestroy
--------------------------
- stereotype annotations
    1. @Component
    2. @Contrller
    3. @RestController
    4. @Service
    5. @Repository
------------------------
- SpEL
    1. @PropertySource({"classpath:demo.properties"})
    2. @Value("${log.filepath}") -> takes value from properties file ($ for properties file values)
    3. @Value("#{e1.email}") ->  e1.getEmail() method called to get email (# for class field)
    3. @ConfigurationProperties(prefix = "p2") : using properties file prefix

---
- Beans from non root packages 
    1.  @ComponentScan

----


When developing RESTful APIs with Spring, several annotations are commonly used to define controllers, map HTTP requests to handler methods, and configure responses. Here’s a list of the most frequently used annotations for creating APIs in Spring:

### 1. **@RestController**
- A convenience annotation that combines `@Controller` and `@ResponseBody`. It indicates that the class is a controller where every method returns a domain object instead of a view. It automatically serializes the returned objects to JSON or XML.

  ```java
  import org.springframework.web.bind.annotation.RestController;

  @RestController
  public class MyApiController {
      // API methods
  }
  ```

### 2. **@RequestMapping**
- Used to map HTTP requests to specific handler methods in the controller. It can be applied at the class level or method level. You can specify the HTTP method, URL, and other attributes.

  ```java
  import org.springframework.web.bind.annotation.RequestMapping;

  @RestController
  @RequestMapping("/api")
  public class MyApiController {
      
      @RequestMapping("/hello")
      public String hello() {
          return "Hello, World!";
      }
  }
  ```

### 3. **@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**
- Specialized variants of `@RequestMapping` that are used to handle HTTP GET, POST, PUT, and DELETE requests, respectively. They simplify the mapping by directly indicating the HTTP method.

  ```java
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PostMapping;

  @RestController
  @RequestMapping("/api")
  public class MyApiController {
      
      @GetMapping("/items")
      public List<Item> getItems() {
          // Logic to return items
      }

      @PostMapping("/items")
      public Item createItem(@RequestBody Item item) {
          // Logic to create an item
      }
  }
  ```

### 4. **@PathVariable**
- Used to bind method parameters to URI template variables. It allows you to extract values from the URL.

  ```java
  import org.springframework.web.bind.annotation.PathVariable;

  @GetMapping("/items/{id}")
  public Item getItemById(@PathVariable String id) {
      // Logic to retrieve an item by ID
  }
  ```

### 5. **@RequestParam**
- Used to extract query parameters from the URL. You can specify default values and whether the parameter is required.

  ```java
  import org.springframework.web.bind.annotation.RequestParam;

  @GetMapping("/items")
  public List<Item> getItems(@RequestParam(required = false) String category) {
      // Logic to filter items by category
  }
  ```

### 6. **@RequestBody**
- Indicates that the method parameter should be bound to the body of the HTTP request. It is typically used for POST and PUT requests where you send JSON or XML data.

  ```java
  @PostMapping("/items")
  public Item createItem(@RequestBody Item item) {
      // Logic to create an item from the request body
  }
  ```

### 7. **@ResponseStatus**
- Used to specify the HTTP status code to be returned with the response. You can annotate a method or an exception class with this annotation.

  ```java
  import org.springframework.http.HttpStatus;
  import org.springframework.web.bind.annotation.ResponseStatus;

  @PostMapping("/items")
  @ResponseStatus(HttpStatus.CREATED)
  public Item createItem(@RequestBody Item item) {
      // Logic to create an item
  }
  ```

### 8. **@ExceptionHandler**
- Used to handle exceptions thrown by controller methods. You can define a method in the controller to handle specific exceptions and return a custom response.

  ```java
  import org.springframework.web.bind.annotation.ExceptionHandler;

  @ExceptionHandler(ItemNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleItemNotFound(ItemNotFoundException ex) {
      return ex.getMessage();
  }
  ```

### 9. **@CrossOrigin**
- Used to enable Cross-Origin Resource Sharing (CORS) on a controller or method, allowing your API to be accessed from different domains.

  ```java
  import org.springframework.web.bind.annotation.CrossOrigin;

  @CrossOrigin(origins = "http://example.com")
  @GetMapping("/items")
  public List<Item> getItems() {
      // Logic to retrieve items
  }
  ```

### 10. **@Valid**
- Used in conjunction with `@RequestBody` to validate the request body against the specified validation constraints (e.g., using JSR-303/JSR-380).

  ```java
  import javax.validation.Valid;

  @PostMapping("/items")
  public Item createItem(@Valid @RequestBody Item item) {
      // Logic to create a validated item
  }
  ```
