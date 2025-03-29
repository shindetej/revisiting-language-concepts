Here are 15 conceptual Java Stream API questions categorized by difficulty:  

### **Beginner Level**  
1. **Filter employees older than 35**  
   *(Basic filtering using `filter()`)*  

2. **Extract a list of employee names**  
   *(Transforming using `map()`)*  

3. **Find the sum of all employee salaries**  
   *(Using `mapToDouble()` and `sum()`)*  

4. **Find department-wise count of employees**  
   *(Using `Collectors.groupingBy()` with counting)*  

5. **Check if all employees have a salary greater than 30,000**  
   *(Using `allMatch()`)*  

### **Intermediate Level**  
6. **Find the employee with the highest salary**  
   *(Using `max(Comparator.comparing(Employee::getSalary))`)*  

7. **Find the second-highest salary given by the organization**  
   *(Using `sorted()` and `limit()`/`skip()`)*  

8. **Group employees by department and calculate their average salary**  
   *(Using `Collectors.groupingBy()` and `Collectors.averagingDouble()`)*  

9. **Find the department with the highest number of employees**  
   *(Using `Collectors.groupingBy()` and `maxBy()` on count)*  

10. **Get a list of all employees sorted by name, then by age**  
    *(Using `sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))`)*  

### **Advanced Level**  
11. **Find the top 3 highest salaries in the organization**  
    *(Using `sorted(Comparator.comparing(Employee::getSalary).reversed())` and `limit(3)`)*  

12. **Partition employees into two groups: earning more than 50,000 and others**  
    *(Using `Collectors.partitioningBy()`)*  

13. **Find employees who have duplicate names (i.e., appearing more than once)**  
    *(Using `Collectors.groupingBy()` and filtering entries with count > 1)*  

14. **Find the department with the highest total salary payout**  
    *(Using `Collectors.groupingBy()` with `summarizingDouble()` and `maxBy()`)*  

15. **Get a comma-separated string of all employee names sorted alphabetically**  
    *(Using `map(Employee::getName)`, `sorted()`, and `Collectors.joining(", ")`)*  
