### LIST OF ANNOTATIONS WITH USAGE MEANING
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
