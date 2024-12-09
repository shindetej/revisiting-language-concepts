## 1. SQL vs NoSQL ( Design level question )

## 2. Categorization of SQL Commands  (DDL | DML | DQL | TCL )

1. **DDL (Data Definition Language)**  
   - Commands used to define, alter, or delete database objects.  
     - `CREATE`  
     - `ALTER`  
     - `DROP`  
     - `TRUNCATE`  
     - `RENAME`  

2. **DML (Data Manipulation Language)**  
   - Commands used to retrieve, insert, update, or delete data in tables.  
     - `SELECT`  
     - `INSERT`  
     - `UPDATE`  
     - `DELETE`  

3. **DCL (Data Control Language)**  
   - Commands used to control access to the database.  
     - `GRANT`  
     - `REVOKE`  

4. **TCL (Transaction Control Language)**  
   - Commands used to manage database transactions.  
     - `COMMIT`  
     - `ROLLBACK`  
     - `SAVEPOINT`  
     - `SET TRANSACTION`  

5. **DQL (Data Query Language)**  
    - `SELECT` (also considered part of DML in broader contexts).  
---
## 3.  SQL Foundation  
1. Data Types in SQL  
2. Basic SQL Commands:  
3. Filtering Data:  
   - WHERE Clause  
   - Comparison Operators  
   - Logical Operators (AND, OR, NOT)  
   - IN, BETWEEN, LIKE  
4. Sorting Data:  
   - ORDER BY Clause  
5. Aggregate Functions:  
   - COUNT, SUM, AVG, MAX, MIN  
6. GROUP BY and HAVING Clauses  
7. Joins:  
   - INNER JOIN  
   - LEFT JOIN  
   - RIGHT JOIN  
   - FULL OUTER JOIN  
   - CROSS JOIN  
8. Subqueries:  
   - Single-row Subqueries  
   - Multi-row Subqueries  
   - Correlated Subqueries  
9. Set Operations:  
    - UNION  
    - INTERSECT  
    - EXCEPT  
10. Constraints:  
    - Primary Key  
    - Foreign Key  
    - Unique  
    - Check  
    - Default  
11. Transactions:  
    - COMMIT  
    - ROLLBACK  
    - SAVEPOINT  
12. Views  
13. Stored Procedures and Functions   
24. Basic Database Design Concepts
---

## 4. Widely Used SQL Topics (80/20 Rule)  

1. **Joins**: INNER, LEFT, RIGHT, FULL  
2. **Subqueries**: Inline, Correlated Subqueries  
3. **Indexes**: Basics and Performance Implications  
4. **Aggregations**: COUNT, SUM, AVG, MIN, MAX, GROUP BY, HAVING  
5. **Common Table Expressions (CTEs)**: WITH clause  
6. **Window Functions**: ROW_NUMBER, RANK, LAG, LEAD  
7. **Transactions**: COMMIT, ROLLBACK, Isolation Levels  
8. **Query Performance Tuning**: Execution Plans, Optimizing Queries  
9. **Data Integrity**: Primary Keys, Foreign Keys, Unique Constraints  
10. **Handling NULL Values**: COALESCE, ISNULL, NULL-safe Comparisons  
