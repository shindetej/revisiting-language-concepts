## SPRING BEAN SCOPES
- spring bean is object of java class created by spring container
####  **What Is Bean Scope?**
-  The scope of a bean defines its lifecycle and visibility within the Spring container.
-  It determines how many instances of a bean are created and how they are shared among different components in the application. 

#### **Total 4 Bean Scopes**
    1. Singleton
    2. Prototype
    3. Request and session
    4. Application

#### **Singleton**
- It is default scope of a spring bean
- ***Only one instance of the bean is created and shared across the entire Spring container***
- *Lifecycle*: The singleton bean is created when the application context is initialized and destroyed when the context is closed.
- *usage*  : Use this scope for stateless beans that do not maintain any state specific to a user or session. 
-  singleton bean different than singleton class : 
    - Must be handled explicitly by the developer
    - Controlled by a static method (like getInstance())
    - Its a design pattern that you control within the class itself.
    - if you call more than one time this class' object same object reference is returned (factory method :  classname.getInstance())

> NOTE : singleton class is different than singleton bean 
- A scope in the Spring Application Context that limits the number of instances of a bean to one. However, the same bean can have multiple instances in the Spring Constants with different bean names
- Java singleton class is per classloader and Spring's singleton is per application context("per container per bean").


#### **Prototype**
- A new instance of the bean is created each time it is requested from the Spring container.
- The prototype bean is created and managed by the container only during its instantiation. However, once the prototype bean is returned to the caller, Spring does not manage its lifecycle.
- It does not call the @PreDestroy method or any cleanup logic when the bean is no longer needed;
- *useful in scenarios where the state of the bean should not be shared among different users or requests.*
```java
@Bean
@Scope("prototype")
public Book BookBean() {
    return new Book();
}
```

#### **Request**
- It is web-only scope
- A new instance of the bean is created for each HTTP request in a web application. 
- available for the entire lifecycle of the request.
- *Use* :  this scope for beans that are specific to a single HTTP request, such as controllers or services that handle request data.
```java
@Bean
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public MyService myService() {
    return new MyService();
}
```

#### **Session Scope**
- It is web-only scope
- A new instance of the bean is created for each HTTP session.
- *Use* for storing session-specific data, like user information that needs to be accessed across multiple requests in a session.
- **Lifecycle** :  The bean is alive for the entire session and is destroyed when the session ends.
```java
@Component
@Scope("session")
public class SessionScopedBean {
    // A single instance of this bean is created per session
}
```

#### **Application Scope (@Scope("application"))**
- A single bean instance is shared across the entire servlet context in a web application.
-  Useful when a bean needs to be shared across multiple sessions and requests in a web application.
- Lifecycle: The bean instance is created once and lives as long as the servlet context
```java
@Component
@Scope("application")
public class ApplicationScopedBean {
    // Single instance of this bean shared across the entire application
}
```