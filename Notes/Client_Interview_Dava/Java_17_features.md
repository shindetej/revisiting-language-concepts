## **Java 17 Features (LTS)**  
1. **Sealed Classes and Interfaces** (Final)  
2. **Pattern Matching for Switch (Preview)**  
3. **New String Methods** (`stripIndent()`, `translateEscapes()`)  
4. **New Random Number Generators (RNG)**  
5. **Strongly Encapsulated JDK Internals**  
6. **Deprecation of Security Manager**  
7. **Removal of RMI Activation System**  
8. **Foreign Function & Memory API (Incubator)**  
---
### Sealed Classes and Interfaces 
-  Before Java 17, Java had no built-in mechanism to restrict which classes can extend a superclass.
- Developers had to rely on
    - Final classes,which prevents inheritance entirely
    - Package-private constructors, which limit instantiation but not subclassing in the same package.

- Sealed classes allow ***controlled inheritance*** , making the class hierarchy ***more secure,maintainable,predictable***.
- Benefits: 
    -  Encapsulation : to privents unauthorized subclassing
    -  Pattern matching : Helps in `switch` expressions with sealed class hierarchies
    -  Readability : clearly defines who is allowed.
---

### Q1. What are the three types of permitted subclasses for a sealed class, and how do they differ?
-  sealed class in Java 17 allows only specific subclasses, and those subclasses must declare how they continue the hierarchy. There are three types of permitted subclasses: 
#### **1. `final` Subclass (No Further Inheritance)**
- Completely **stops inheritance** beyond this class.  
- Used when you want a **concrete, immutable implementation** of the sealed class.  
 
```java
sealed class Shape permits Circle, Rectangle { }

final class Circle extends Shape { }  // Cannot be extended further
```
**Use case:**  
- When you know a class should never have more variations.  
- Ensures security and predictability.

---

#### **2. `sealed` Subclass (Controlled Inheritance)**
- Continues the **sealing mechanism**, meaning this subclass must **explicitly permit** its own subclasses.  
- Used when you want **controlled** but **limited extensibility**.  

```java
sealed class Shape permits Circle, Rectangle { }

sealed class Rectangle extends Shape permits Square, RoundedRectangle { }

final class Square extends Rectangle { }  // No further extension
non-sealed class RoundedRectangle extends Rectangle { }  // Open for extension
```
**Use case:**  
- When a subclass represents **multiple specialized types** (e.g., `Rectangle` → `Square`, `RoundedRectangle`).  
- Keeps **fine-grained control** over hierarchy.

---

#### **3. `non-sealed` Subclass (Open for Extension)**
- **Removes restrictions**, allowing unlimited inheritance.  
- Used when you want to **stop restricting the hierarchy** at a certain level.  
  
```java
sealed class Shape permits Circle, Rectangle, Triangle { }

non-sealed class Triangle extends Shape { }  // Can be subclassed freely
```
**Use case:**  
- When a subclass is expected to **evolve freely** in the future.  
- Allows both flexibility and initial control over class design.

---

### **Comparison**

| Subclass Type  | Can Be Further Extended? | Controls Inheritance? | Use Case |
|---------------|----------------------|-------------------|---------|
| `final`       | ❌ No                 | ✅ Yes            | When you don’t want further extension |
| `sealed`      | ✅ Yes (but controlled) | ✅ Yes            | When you want to restrict which classes extend further |
| `non-sealed`  | ✅ Yes (unlimited)     | ❌ No             | When you want to remove all restrictions |
---

### Q2. Pragmatic usecases of sealed classes and interfaces
- Sealed classes are most useful in ***domain-driven design, framework design, and API security*** where controlling inheritance is critical. 

1. Defining a Controlled Event System (Event-Driven Architecture)