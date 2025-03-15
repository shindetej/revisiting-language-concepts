## What is Stream in Java 8?
- A Stream in Java 8 is a ***sequence of elements generated from a data source*** that **flows through a pipeline of operations (intermediate and terminal)**, ***processed lazily in a functional style, without modifying the original source***.

- data sources to generate stream:
    1. Collections : List,Set,Queue (ex. list.stream())
    2. Arrays : Arrays.stream(array)
    3. Streams.of() - Streams.of(1,2,3)
    4. Files and I/O - Files.lines(path)
    5. primitive streams - IntStream,LongStream,DoubleStream
    6. Custom generators - Stream.generate
- A Stream pipeline consists of a source, intermediate operations, and a terminal operation.
- **Streams lazily evaluate operations in a functional style** :
    1. meaning intermediate operations do not execute immediately. They are only processed when a terminal operation is invoked. 
    2. If no terminal operation is present, the stream does nothing
    3. analogy : to an open circuit where current cannot flow unless connected to ground
        - Intermediate operations are like resistors and transformers
        - terminal operation  = connecting circuit to ground.


## Stream Pipeline Structure
```java
        List<String> names = Arrays.asList("Alice","Bob","Charlie","Aaron","Marie","Chen","Mahi");
		
		// creating stream
		Stream<String> stream = names.stream();
		
		// intermediate operation
		Stream<String> filteredStream = stream.filter(name->name.startsWith("C"));
		
		// terminal opertaion to produce /execute result
		List<String> result = filteredStream.collect(Collectors.toList());
		
		
		// can be done in one line
		List<String> resultMNames=  names.stream().filter(name->name.startsWith("M")).collect(Collectors.toList());
		System.out.println("Result with C started names : "+result);
		System.out.println("Result with M started names : "+resultMNames);
```


## Intermediate Operations (Transformations) 
1.  filter(Predicate<T>) 
    - Filters elements based on a condition and returns a new Stream with matching elements.
    ```java
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        System.out.println(evens); // Output: [2, 4]
    ```
2. map(Function<T, R>) 
    - Transforms each element into another form (one-to-one mapping).
    ```java
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String> upperNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(upperNames); // Output: [ALICE, BOB, CHARLIE]

    ```

3. flatMap(Function<T, Stream<R>>)
    - Flattens nested structures into a single continuous stream.
    ```java
            // Ex 1
            List<List<String>> studentCourses = Arrays.asList(
                Arrays.asList("Maths", "Physics", "Chemistry"),
				Arrays.asList("Economics", "Statistics", "Maths"), 
                Arrays.asList("Marathi", "History", "Englist"));
		    
		    Set<String> uniqueSubjects = studentCourses.stream()
											.flatMap(s-> s.stream()) // you can use List::stream
											.collect(Collectors.toSet());
		    System.out.println("flatten set of subjects :: "+ uniqueSubjects);

            // Ex 2 : get list of products from customer details
            List<Customer> customers = Arrays.asList(
				new Customer("Raj",Arrays.asList("Mobile","Watch")),
				new Customer("Teja",Arrays.asList("Laptop","Tata Namak"))
				);
		    List<String> productList = customers.stream()
											.flatMap(cust->cust.getOrders().stream())
											.toList();
		
		    System.out.println(productList);
    ```

4. sorted()
    - 
5. distinct()
    - Removes duplicate elements from the stream based on equals().
    ```java
        List<Integer> uniqueNums = nums.stream().distinct().collect(Collectors.toList());
    ```
6. limit(n)
    - Restricts the stream to the first n elements.
    ```java

        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n + 1);
        List<Integer> firstThree = infiniteStream
            .limit(3)
            .collect(Collectors.toList());

        System.out.println(firstThree); // Output: [1, 2, 3]

    ```
7. skip(n)
8. peek(Consumer<T>)
