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
    2. @Value("${log.filepath}")
    3. @ConfigurationProperties(prefix = "p2") : using properties file prefix

---
- Beans from non root packages 
    1.  @ComponentScan