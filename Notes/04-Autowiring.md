## AutoWiring 
-  Autowiring is a feature in the Spring Framework that allows **the automatic injection of dependencies into a Spring bean** without explicitly specifying the configuration
-  Reducing the need for manual @Bean configurations and XML wiring.
-  IN Earlier demos although spring container doing DI but we were somehow giving inputs in app.config or with properties file to what fields to be taken while injecting bean (Person bean injecting inside Account bean) 
---
### **Types of Autowiring **
1. Setter level : setter based DI
2. Constructor based :  contructro based DI
3. field based  : field based DI


---

### Make autowiring optional to inject bean
#### *Exception : no bean found*
![](optional_autowiring.png)
- **Use `@Autowired(required=false)` for a Default Bean:**
```java
	@Autowired(required=false)
	Logger logger;
```
- You can mark a bean as optional by setting required=false **or using java.util.Optional**
---
#### **Multiple beans of the same type**
When you have **multiple beans of the same type** (e.g., different implementations of an interface) and need to control which one should be injected into your components.

![](bean_conflict_autowire.png)
### When to Use `@Primary` and `@Qualifier` in Autowiring




1. **Use `@Primary` for a Default Bean:**
   - **When:** One of the beans should act as the default choice across your application when multiple beans exist.
   - **How:** Annotate the preferred default bean with `@Primary`. This ensures it is injected when no specific bean is qualified.
  

2. **Use `@Qualifier` for Specific Beans:**
   - **When:** You need to inject a **specific bean** in certain places, even if a default (`@Primary`) bean exists.
   - **How:** Use `@Qualifier` to explicitly specify which bean to inject.

#### **When to Apply This Approach:**
- **Multiple Implementations**: When your application has different implementations of an interface or class (e.g., `PrimaryService`, `SecondaryService`) and you need to inject the right one in different contexts.
- **Default vs Specific Needs**: Use `@Primary` for common cases and `@Qualifier` for more specific needs.

#### **Exception came with multiple beans**
![](handle_two_beans_in_autowire.png)

#### **Code snippet**
![](handle_two_beans_in_autowire2.png)

---

####  **Field Injection vs Constructor Injection (Best practices)**
- **Field Injection:** Using @Autowired directly on fields is convenient but considered less flexible in terms of testing and immutability.
- **Constructor Injection:** Encouraged as a best practice because it ensures that all dependencies are provided when the object is created, promoting immutability and easier testing.
Practical Tip: Use constructor injection in your Spring components for better maintainability and testability.