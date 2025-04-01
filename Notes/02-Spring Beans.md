Lifecycle :
- A Spring Bean is any Java object registered within the Spring IoC container.
- Beans are created, configured, and managed by Spring. 
- Bean life cycle is managed by the spring container. 

Bean lifecycle :
> Bean Instantiation -> Dependency Injection -> Pre-Initialization ->
Custom Initialization -> Ready for Use -> Pre-Destruction -> Custom Destruction -> Bean Removed

### **Spring Bean Lifecycle**
The lifecycle of a Spring Bean consists of several phases, from instantiation to destruction. Here are the steps:

1. **Bean Instantiation**:
   - The IoC container instantiates the bean based on the bean definition.

2. **Populate Properties**:
   - The container injects dependencies into the bean (using setter injection, constructor injection, or field injection).

3. **`BeanNameAware` Callback** (Optional):
   - If the bean implements `BeanNameAware`, it receives its bean name.

4. **`BeanFactoryAware` Callback** (Optional):
   - If the bean implements `BeanFactoryAware`, it gets a reference to the `BeanFactory`.

5. **Pre-Initialization (`@PostConstruct` or `InitializingBean`)**:
   - The container calls `@PostConstruct`-annotated methods or `afterPropertiesSet()` if the bean implements the `InitializingBean` interface.

6. **Custom Initialization Method (Optional)**:
   - If an `init-method` is specified in the configuration or the bean has a custom initialization method, this is invoked.

7. **Bean Ready for Use**:
   - The bean is fully initialized and ready to be used by the application.

8. **Pre-Destruction (`@PreDestroy` or `DisposableBean`)**:
   - Before the bean is destroyed, `@PreDestroy`-annotated methods or `destroy()` (if the bean implements `DisposableBean`) are called.

9. **Custom Destroy Method (Optional)**:
   - If a custom destroy method is specified, it is invoked.

10. **Bean Destruction**:
    - The container removes the bean from the IoC container.


---

### **Key Annotations and Interfaces**
1. **Annotations**:
   - `@Component`: Marks a class as a Spring-managed bean.
   - `@PostConstruct`: Defines a method to run after dependency injection.
   - `@PreDestroy`: Defines a method to run before the bean is destroyed.

2. **Interfaces**:
   - `BeanNameAware`: Provides the bean's name.
   - `BeanFactoryAware`: Provides access to the `BeanFactory`.
   - `InitializingBean`: Defines a method (`afterPropertiesSet`) called after dependency injection.
   - `DisposableBean`: Defines a method (`destroy`) called before destruction.

--- 
### Spring bean lifecycle : 

1. Jvm calls main()
2. SpringApplication.run() does the following:
    1. Create ApplicationContext (Spring Container)
    2. Load and instantiate beans (singleton beans by default)
    3. Perform dependency injection
    4. Call lifecycle methods (@PostConstruct, InitializingBean, custom init method)
    5. Execute CommandLineRunner or ApplicationRunner if defined
    6. Handle bean destruction at shutdown (@PreDestroy, DisposableBean)
---

### In  SpringLifeCycleDemo Below Lifecycle followed
-  Lifecycle Steps for rect1 Bean: 
    1. Instantiation of the Rectangle Object
    2. Dependency Injection (Setter Injection):
    3. BeanNameAware - Setting the Bean Name:
    4. BeanPostProcessor - Before Initialization:
    5. Custom Initialization with @PostConstruct:
    6. InitializingBean - afterPropertiesSet():
    7. BeanPostProcessor - After Initialization:
    8. Using the rect1 Bean (calcArea()): **BUSINESS LOGIC** 
    9. Destruction Phase - @PreDestroy:
    10. DisposableBean - destroy():
- Lifecycle Steps for rect2 Bean: 
    1. Constructor Injection: 
    2. All other steps from 3 to 10 as above

    
---
- @SpringBootApplication : @ComponentScan + @Configuration +  @EnableAutoConfiguration + many other annotations

- @ComponentScan : 
    - scans base package and its subpackage for detecting  components(@Component, @Service, @Repository, @Controller, etc.) to register these annotated classes as beans in spring context
    - also used to scan other than base package 
        - @ComponentScan(basePackages = "com.example")
- @Configuration :  Tells spring context that this class contains bean configurations that need to be registered in the Spring application context.

- @EnableAutoConfiguration: tells Spring Boot to automatically configure your application based on the dependencies and configurations available on the classpath.
---





