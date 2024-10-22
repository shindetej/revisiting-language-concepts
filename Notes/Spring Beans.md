Lifecycle :

Bean lifecycle :
1. **Bean Instantiation**: Spring creates the bean.
2. **Dependency Injection**: Spring injects dependencies or properties.
3. **Custom Initialization**: Any initialization logic runs (optional).
4. **Ready for Use**: The bean is fully configured and can be used.
5. **Destruction**: Cleanup happens before the bean is removed (optional).


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
    2. All other steps from 3 to 10 as it is

    
---
- @SpringBootApplication : @ComponentScan + @Configuration +  @EnableAutoConfiguration + many other annotations

- @ComponentScan : 
    - scans base package and its subpackage for detecting  components(@Component, @Service, @Repository, @Controller, etc.) to register these annotated classes as beans in spring context
    - also used to scan other than base package 
        - @ComponentScan(basePackages = "com.example")
- @Configuration :  Tells spring context that this class contains bean configurations that need to be registered in the Spring application context.

- @EnableAutoConfiguration: tells Spring Boot to automatically configure your application based on the dependencies and configurations available on the classpath.
---



