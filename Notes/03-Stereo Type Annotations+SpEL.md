### INTRO
- Earlier we are taking efforts to create each bean : not recommended to write every bean in app.config
- **Stereotype annotations are special annotations used to define the role or purpose of a Spring-managed component within the application.**
- Auto detecting beans using
    1. @Component
    2. @Contrller
    3. @RestController
    4. @Service
    5. @Repository

- @Controller and @RestController are used in Web application to control request responses, can not be used in console applications
- @Service and @Repository used for business logic and database activities repectively
- if you want your component class as bean in spring container but it is not request-response class/business logic/db logic class use @Component

---

### SpEL
- Use @Value annotation to get properties from properties file
    - create demo.properties file
    - add it in app config over class
        ```java
        @PropertySource({"classpath:demo.properties"})
        @Configuration
        public class AppConfig {---}
        ```
    - create seperate properties file for seperate purposes is good practice(hibernate,security config etc.)
    - in file logger : log file path field annoted with @Value
    ```java
    @Value("${log.filepath}")
	private String logFilePath;
    ```
    

- Add multiple instance in properties file
    - add instance field with variable as prefix
        ```properties
        p1.name=adfgh
        p1.mobile=224590922
        p1.email=teja@gmail.com
        p1.age=29

        p2.name=lkjhgf
        p2.mobile=494839109
        p2.email=v@gmail.com
        p2.age=26
        ```
    - then use @ConfigurationProperties to get those details of fields in bean creation process
        ```java 	
        @ConfigurationProperties(prefix = "p1")
        @Bean
        public Person person1() {
            return new PersonImpl();
        }

        @ConfigurationProperties(prefix = "p2")
        @Bean
        public Person person2() {
            return new PersonImpl();
        }
        ```
        - if field not present - default value 0 or null taken

- If properties file have dependecy bean like Account has person (handled exception : Failed to bind properties under 'a2.person' to com.tejas.model.Person: failed to convert java.lang.String to com.tejas.model.Person)
    - use Convseter<S,T>
    - implemented methods Converter<String, Person>, ApplicationContextAware 
    - you can get application context by using autowired also
    - get person context and return it by taking input string beanname as source
    ```java
    	@Override
	public Person convert(String source) {
		return (Person) this.context.getBean(source);
	}

    ``` 
    - add annotation to bind config properties over class along with @Component -> @ConfigurationPropertiesBinding