## HIBERNATE BASICS 

1. Object Relational Mapping : a programming technique that connects object-oriented programming (OOP) code with a relational database

2. Benefits of ORM :
    - To address, access, and manipulate objects without needing to consider how they relate to their data sources.
    - Removing the need for boilerplate code 
    - ORMs can help with code reuse. 
    - Help maintaining an application over time. 
3. Drawback : impedance mismatch
4. Hibernate is popular ORM tool. others are iBatis,EclipseLink
5. JPA is specification(contract) for ORM tools
6. OOP : RDBMS Mapping
    - **Class** : Table  
    - **Object of class** : Row of table  
    - **Fields of class** : columns of table
---


![](hibernate_struct.png)


---
![](object_to_record.png)

---

#### **Hibernate Architecture**
-  It is designed such that to abstract the complexities of database interactions, allowing developers to work with objects in Java rather than dealing directly with SQL and database tables.
1. Configuration Object
    - hibernate.cfg.xml file
    - responsible for creating `SessionFactory`
    - loads the database connection settings, Hibernate properties, and class-to-table mappings from the configuration file.

2. **SessionFactory :**
    - The `SessionFactory` is a thread-safe, immutable object that acts as a factory for creating `Session` objects.
    - One SessionFactory (SF) per application(per db).
    - SessionFactory is heavy object so practice to make singleton class
    - DriverManager.getConnection() in jdbc makes connection (using sockets across tcp ip) --- Session is created by SF to wrapper these activities 


3. **Session :** 
    -  Represents a single unit of work with the database.
    - You can multiple sessions by SF method call
    - it encapsulates jdbc connection
    - session is lightweight hence created and destroyed for single transaction
    - not a thread-safe
    - use cases : 
        1. Managing CRUD operations on persistent entities.
        2. Holding a temporary cache during the lifecycle of a session. 

4. **Transaction :** 
    - The Transaction object allows the application to commit or roll back changes made within a session in a safe way.
    - abstracts the underlying database transactions (such as BEGIN, COMMIT, ROLLBACK)
    ```java
    Transaction tx = session.beginTransaction();
    // Perform operations
    tx.commit(); 
    ```

5. **Query Object :**
    - Hibernate supports two types of queries:
        1. HQL :  similar to SQL but works with objects, not tables.
        2. Native SQL querings
- Sql based native queries also called if complexity is hight. there are also hibernate query language(hql)
- In case of SPs, Procedure call is wrapper on callable statement.


6. Criteria Object (deprecated,not expected )
    - more programmatic way to build dynamic queries in Hibernate. 
    ```java
    Criteria criteria = session.createCriteria(Employee.class);
    criteria.add(Restrictions.eq("empid", 101));
    List<Employee> employees = criteria.list();
    ```

7. Hibernate Dialect
    - Dialect class is responsible for generating appropriate SQL queries for the target database.
    - Specific to the underlying database (e.g., MySQL, PostgreSQL, Oracle). 
    ```xml
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    ```
8. Connectip  provider
    - By default, Hibernate uses JDBC connections, but you can configure other connection pool providers like HikariCP.

9. Entity Classes (POJOs)
    -  represent the business model in the application.
    - Each entity class is mapped to a table in the database

    
```mathematica
Application
    ↓
Configuration (hibernate.cfg.xml)
    ↓
SessionFactory (Singleton, Thread-Safe)
    ↓
Session (Not Thread-Safe)
    ↓            → Transaction
Query/Criteria   → Execute SQL (HQL, Native Queries)
    ↓
Database (CRUD operations)
    ↓
Session Close

```