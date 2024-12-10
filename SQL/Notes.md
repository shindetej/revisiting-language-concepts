### ACID
1.  Atomicity :  ensures that either **all operations within a transaction are completed successfully or none of them are**.
2. Consistency :  ensures that the **database remains in a valid state before and after transactions**, enforcing constraints and maintaining data integrity.
3. Isolation  : ensures that **transactions operate independently of each other, preventing interference or inconsistency** when executed concurrently.
4. Durability :  guarantees that **once a transaction is committed, its changes are permanently stored in the database** even in the event of system failures.

### SELECT QUERY EXECUTION ORDER:
1. **FROM**: Identify and load the `employees` table.
2. **WHERE**: Filter rows where `salary > 50000`.
3. **GROUP BY**: Group the remaining rows by `department_id`.
4. **HAVING**: Filter groups where `COUNT(*) > 5`.
5. **SELECT**: Retrieve `department_id` and compute `COUNT(*) AS employee_count`.
6. **ORDER BY**: Sort the result by `employee_count` in descending order.
7. **LIMIT**: Return the top 10 rows from the sorted result.

### WHERE Vs HAVING Clause
- Where
    - Where applied on individual rows(records)
    - Filters rows before any grouping or aggregation is performed.
    ```sql
    SELECT employee_id, salary
    FROM employees
    WHERE salary > 50000;

    ```
- Having 
    - when you need to apply filters on aggregated values (using aggregated functions like SUM(),AVG(),COUNT())
    ```sql
    SELECT department_id, COUNT(*) AS employee_count
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) > 5;

    ```





## WINDOW FUNCTIONS
###  1.1 RANK() Vs DENSE_RANK() Vs ROW_NUMBER()

The functions `RANK()`, `DENSE_RANK()`, and `ROW_NUMBER()` are window functions in SQL that assign unique numbers to rows in a result set, based on a specified order. While they share similarities, they differ in how they handle ties (rows with the same ranking).

### 1. **RANK()**
- **Purpose**: Assigns a rank to each row, leaving gaps between ranks when there are ties.
- **Behavior**: If two rows are tied, they will receive the same rank, but the next rank will skip numbers based on the number of tied rows.
- **Example**: If three rows have ranks 1, 2, and 2 (tied), the next row will be ranked 4.

---

### 2. **DENSE_RANK()**
- **Purpose**: Similar to `RANK()`, but without skipping ranks for ties.
- **Behavior**: Tied rows receive the same rank, and the next rank is sequential.
- **Example**: If three rows have ranks 1, 2, and 2 (tied), the next row will be ranked 3.

---

### 3. **ROW_NUMBER()**
- **Purpose**: Assigns a unique sequential number to each row, regardless of ties.
- **Behavior**: There are no ties; each row gets a distinct number.
- **Example**: If three rows have values 90, 90, and 80, they will receive ranks 1, 2, and 3, based on the specified order.
---

### Common Query Syntax
```sql
SELECT emp_no,
    first_name,
    dept_name,
    salary,
    RANK() over(order by salary) as rank_col,
    DENSE_RANK() over(order by salary) as dense_rank_col, 
    ROW_NUMBER() over (order by salary) as row_num
FROM my_employee_schema.employees;
```
---

### 1.2  Use of Partition By
- The `PARTITION BY` clause is used in SQL with window functions to divide the result set into subsets (partitions) and apply the window function independently to each subset.

```sql
<window_function>() OVER (PARTITION BY column_name(s) [ORDER BY column_name(s)])
```
- example 1
```sql
-- replace in above select query
   RANK() over (partition by dept_name order by salary) as rank_col,
 DENSE_RANK() over (partition by dept_name order by salary) as drank,
 ROW_NUMBER() over (partition by dept_name order by salary) as row_num
```

- example 2 - get sum of sales by each sales person for each region
```sql
SELECT
    region,
    salesperson,
    sales,
    SUM(sales) OVER (PARTITION BY region ORDER BY salesperson) AS cumulative_sales
FROM sales_data;
```