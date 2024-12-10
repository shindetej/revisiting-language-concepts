## GENERICS IN JAVA
---
> **INTRODUCTION**
- This chapter : describes the syntax, theory, and use of generics
- Two profound impact when it introduced in java JDK5
    - it added a new syntactical element to the language
    - it caused changes to many of the classes and methods in the core API
- Simply put, if you will be programming in Java SE 6, you will be using generics
> In Oracle documentation :   Type parameters in Generics provide a way for you **to re-use the same code** with different inputs.

- **work in a type safe manner for any kind of data** i.e to create type-safe code in which type-mismatch errors are caught at compile time
- Many algorithms logical same irrespective of type of data is used
- example : stack is the same whether that stack is storing items of type Integer, String, Object,
or Thread.
- ***most significantly affected by generics is the Collections Framework.***

> **Generics means parameterized types.**
- *SYNTAX FOR DECLARING GENERIC CLASS*
    - ***class class-name<type-param-list> { // ...}***
    - public class GenA<T> {}
    - here T is parameterized type , argument to this placeholder is any class type - explained detail later
- *SYNTAX FOR DECLARING  REFERENCE TO GENERIC CLASS*
    - **class-name<type-arg-list> var-name = new  class-name<type-arg-list>(cons-arg-list);**
    
   


- It enables you to create classes ,interfaces,methods in which the type of data on which they operate is speicified as parameter
- possible to create single class ,which works for differnt types of data

- A class,interface, or method that operates on a parameterized type is called generic
    - generic class
    - generic method
    - getneric interface


> A Warning to C++ Programmers: Although generics are similar to templates in C++, they
are not the same. There are some fundamental differences between the two approaches to generic
types. If you have a background in C++, it is important not to jump to conclusions about how
generics work in Java.
---
> Why Generics ? can't we use Object class?
- It is important to understand that Java has always given you the ability to create generalized
classes, interfaces, and methods by operating through references of type **Object**.
- Object
is the superclass of all other classes, an Object reference can refer to any type object. Thus, in
pre-generics code, generalized classes, interfaces, and methods used Object references to
operate on various types of objects.
- **The problem was that they could not do so with type safety.**


> Simple Generics Example :

```java
public class GenA<T>
{
    private T genObj;
    public GenA(T temp)
    {
        // initialise instance variables
        this.genObj = temp;
    }


    public T getT()
    {
        // put your code here
        return this.genObj;
    }

      public void showTypeOfT()
    {
        // put your code here
        System.out.println("Type of Generic class :: "+ genObj.getClass().getName());
    }
}


```
---
```java
public class GenericsMain
{
    public static void main(String [] args)
    {
        // Create Gen Object of Integer
        
        GenA<Integer> iOb = new GenA<Integer>(101);
        // Create Gen Object of String
        
        System.out.println("Integer Generic Type Object  :"+iOb.getT());
        System.out.print("Type(class of object)  :\t");
        iOb.showTypeOfT();
        
         GenA<String> strOb = new GenA<String>("Testing Me!!");
         
        System.out.println("String Generic Type Object  :"+strOb.getT());
        System.out.print("Type(class of object)  :\t");
        strOb.showTypeOfT();
    }
}
//Integer Generic Type Object  :101
//Type(class of object)  :	Type of Generic class :: java.lang.Integer
//String Generic Type Object  :Testing Me!!
//Type(class of object)  :	Type of Generic class :: java.lang.String
```
#### **NOTE** :
- The Java compiler does not actually create different versions of Gen, or of any other generic class.
- **Instead, the compiler removes all generic type
information, substituting the necessary casts, to make your code behave as if a specific version
of Gen were created**.The process of removing generic type information is called erasure
- There is really only one version of Gen that actually exists in your
program.
    - Gen<String> strOb = new Gen<String>("Generics Test");
    creates String version of Gen
    - lly GenA<Integer> iOb = new GenA<Integer>(101); Integer version of Gen
- iOb is of type Gen<Integer>, it can’t be used to refer to an object of Gen<Double>.

---


> Points to note whlie using Generics : 
1. Generics work only with Objects.
    - when instance created, argument passed to type parameter is of class type
    - can not use primitive type

2. Generic Types Differ Based on Their Type Arguments
    - Even though both iOb and strOb are of type Gen<T>,because Type parameter is different
    - so strOb can not be assigned to iOb
        iOb =  strOb ;// error


> How Generics Improves Type Safety?
- Use NonGeneric Demo
```java
class NonGen {
Object ob; // ob is now of type Object
// Pass the constructor a reference to
// an object of type Object
NonGen(Object o) {
ob = o;
}
// Return type Object.
Object getob() {
return ob;}
//....so on
}
```
- here T is of Object type, It can store object of anytype,
- what it can not do is ,compiler can not identify real data type once stored in object type.
    - It results in two consequences
        - explicit casting required while reading data
        - many kinds of type mismatch errors cannot be found until 
        run time
        ```java
        // This compiles, but is conceptually wrong!
            iOb = strOb;
            v = (Integer) iOb.getob(); // runtime error!!!
        ```

>  ***The ability to create type-safe code in which type-mismatch errors are caught at compile time is a key advantage
of generics.***
 once run-time errors have become compile-time errors. This is a major advantage.

---

> ***Generic class with Two Type Parameter***
- class TwoGen<T, V> {}
- TwoGen<Integer, String> tgObj =
new TwoGen<Integer, String>(88, "Generics");

---
>  ***BOUNDED TYPES***
1. sometimes it is useful to limit the types that can be passed to a
type parameter.
    - Application 1 : to specify the type of the numbers generically, using a type parameter.
    ```java
    // create a generic class that can compute
    // the average of an array of numbers of
    // any given type.
    //
    // The class contains an error!
    class Stats<T> {
    T[] nums; // nums is an array of type T
    // Pass the constructor a reference to
    // an array of type T.
        Stats(T[] o) {
        nums = o;
        }
    // Return type double in all cases.
        double average() 
        {
        double sum = 0.0;
        for(int i=0; i < nums.length; i++)
        sum += nums[i].doubleValue(); // Error!!!
        return sum / nums.length;
        }
    }
    ```

    - When specifying a type parameter,you can ***create an upper bound*** that declares the superclass ***from which all type arguments must be derived***.
> NOTE : <T extends superclass> means T can only be replaced by superclass, or subclasses of superclass(inclusive upperlimit)

---
- Stats.java
```java
public class Stats<N extends Number> {
	private N[] nums;
	
	Stats(N[] nums)
	{
		this.nums = nums;
	}

	// return double type
	public double average() {
		System.out.println("Inside average()");
		double sum = 0.0;
		for(int i = 0;i<nums.length;++i)
		{
			sum+=nums[i].doubleValue();
		}
		
		return (sum)/nums.length;
	}
}
```
---
- BoundedTypesDemo.java
```java
package GenDemo1;

public class BoundedTypesDemo {
	public static void main(String[] args) {
		
		Integer iNums[]= {2,3,4,5,6};
		Double dNums[]= {2.5,3.2,4.45,5.65,6.5};
		
		System.out.println(" iNum = "+new Stats<>(iNums).average());
		System.out.println(" dNum = "+new Stats<>(dNums).average());
		
		// This won't compile because String is not a
		// subclass of Number.
		String strs[] = { "1", "2", "3", "4", "5" };
		// Stats<String> strob = new Stats<String>(strs); 
		// Bound mismatch: The type String is not a valid substitute for the bounded parameter <N extends Number> of the type Stats<N>
		
		// double x = strob.average();
	}

}
```

- >Because the type T is now bounded by Number, ***the Java compiler knows that all objects of
type T can call doubleValue( )*** because it is a method declared by Number. This is, by itself,
a major advantage. 
- >  ***the bounding of T also prevents nonnumeric Stats objects from being created***.
- If T must be a class that is a subclass of MyClass and also implements the MyInterface ,called intersection type
```java
class Gen<T extends MyClass & MyInterface> { 
    // ...
}

``` 
- Using wildcard for methods' parameters
    -  what do you specify for Stats’ type parameter when you declare a parameter of that type in a methods argument?
    - Instead of Stats< T >  we can use Stats<?> .... why?
    - using Stats<Integer> can’t be used to compare the
    average of an object of type Stats<Double>
    - Solution  is wildcard
    ```java
    	public boolean sameAvg(Stats<?> other) {
		if (average() == other.average())
			return true;
		return false;
	}
    ```
    - Stats<?> matches any Stats object, allowing any two Stats objects to have their averages compared.
    > **It is important to understand that the wildcard does not affect what type
of Stats objects can be created.** This is governed by the extends clause in the Stats declaration.
The wildcard simply matches any valid Stats object.
---

> **BOUNDED WILDCARDS**

```java
    class Coords<T extends TwoD> {
    T[] coords;
    Coords(T[] o) { coords = o; }
    }
```

```java
    static void showXY(Coords<?> c) {
        System.out.println("X Y Coordinates:");

        for(int i=0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " +
        c.coords[i].y);
        System.out.println();
    }
```
