> **Chatgpt : Please list out points that I need to cover on Exception Handling from basic to latest advanced**

Certainly! Exception handling is an important topic in Java software development interviews. Here is a list of points you should cover, from basic to advanced, to demonstrate your understanding of exception handling in Java:

**Basic Concepts:**

1. **What is an Exception:** Explain what exceptions are and why they are used in Java. Mention that exceptions represent abnormal or unexpected events that can occur during program execution.

2. **Types of Exceptions:** Discuss the two main types of exceptions: checked exceptions (compile-time exceptions) and unchecked exceptions (runtime exceptions).

3. **`Throwable` Hierarchy:** Explain the hierarchy of the `Throwable` class, which is the root class for all exceptions in Java. It has two main subclasses: `Error` and `Exception`.

4. **Handling Exceptions:** Describe how exceptions can be handled using try-catch blocks to gracefully recover from exceptions and prevent program crashes.

5. **`try-catch` Block:** Explain the syntax of a `try-catch` block, where you place code that might throw an exception inside the `try` block and catch the exception in the `catch` block.

6. **`finally` Block:** Discuss the purpose of the `finally` block, which is used to execute code that should always run, whether an exception is thrown or not.

**Intermediate Concepts:**

7. **Multiple `catch` Blocks:** Explain how you can have multiple `catch` blocks for a single `try` block to handle different types of exceptions separately.

8. **`throw` and `throws`:** Discuss the use of the `throw` keyword to explicitly throw exceptions and the `throws` clause to declare that a method may throw a particular exception.

9. **Custom Exceptions:** Describe how to create custom exception classes by extending the `Exception` class or its subclasses to handle application-specific exceptions.

10. **Exception Propagation:** Explain how exceptions propagate up the call stack when they are not caught, leading to the termination of the program or the handling of the exception by a higher-level catch block.

11. **Checked vs. Unchecked Exceptions:** Differentiate between checked exceptions (which must be either caught or declared) and unchecked exceptions (which do not need to be explicitly caught or declared).

**Advanced Concepts:**

12. **Try-With-Resources:** Discuss the try-with-resources statement introduced in Java 7 for automatic resource management and exception handling when working with resources like files, streams, and sockets.

13. **Exception Chaining:** Explain how exceptions can be chained using the `initCause` method to provide more context and information about the root cause of an exception.

14. **`try`-with-Multi-catch:** Discuss the Java 7 feature of catching multiple exceptions in a single catch block using a multi-catch statement.

15. **Suppressed Exceptions:** Describe the concept of suppressed exceptions, which are exceptions that can occur during the closing of resources in try-with-resources, and how they can be accessed using the `getSuppressed` method.

16. **Best Practices:** Mention best practices for exception handling, such as logging exceptions, providing meaningful error messages, and handling exceptions at the appropriate level of abstraction.

17. **Exception Handling Frameworks:** If relevant, discuss popular Java exception handling frameworks like Apache Commons Lang ExceptionUtils or Spring's exception handling mechanisms.

18. **Asynchronous Exception Handling:** If the position involves asynchronous programming, discuss how exceptions are handled in asynchronous code, including CompletableFuture and reactive programming libraries.

19. **Java 9's `try`-With-Resources Enhancement:** If you're aware, mention the enhancement in Java 9 that allows effectively final variables to be used in try-with-resources.

Make sure to provide practical examples and code snippets to illustrate your points during the interview. Demonstrating a strong understanding of exception handling concepts can be a valuable asset in a Java software developer interview.


> **Horstmann Note**
- In the Java programming language, an exception object is always an instance of
a class derived from Throwable .
- Throwable splits into Error & Exception branches
- The Error hierarchy describes internal errors and resource exhaustion situations
inside the Java runtime system. There is little you can do if such an internal error occurs, beyond notifying the user and
trying to terminate the program gracefully. These situations are quite rare
- When doing Java programming, focus on the Exception hierarchy.
- When it is RuntimeException, it was your fault

---
## **JCR BOOK**

> ### EXCEPTION HANDLING -  10th Chapter
---
- Keywords : Abnormal condition, try ,catch ,throw , throws , finally
- Exception is abnormal condition that arises in code at runtime i.e runtime error
- Exception handling  == Run-time error management in OOP
- **java exception is object** 
- Exception occurs --->  Object of exception created --->  thrown in method that caused error
- Two ways of exception generated

- method may choose to handle the exception itself, or pass it on  to be caught and processed--> describe briefly later
- Exception generater either by JRT or manual coding
- JRT errors are fundamental java errors thrown when one violets Java language rules n execution environment

```
Five keywords for exception handling in Java :
try,
catch,
throw,
throws,
finally
```


- To manually **throw** an exception, use the keyword **throw**. Any exception that is thrown out of
a method must be specified as such by a **throws** clause

```java

try
{
  // code under monitoring 
}  
catch(exceptionType1 objectOfException)
{
  // handler code
}
catch(exceptionType2 objectOfException)
{
  // handler code
}
.
.
.
finally{
  //code that absolutely must be executed after a try block
}
```

- All exception types are sub class of built in class Throwable.
- Throwable has two subclasses -  Exception and Error
- Exception has one branch Runtime Exception - ex. DivideByZero , ArrayIndexOutOfBound,NullPointer
- A catch statement cannot catch an exception thrown by another try statement (except in the case of nested try statements, described shortly)
- Role of catch clause: resolve exceptional condition and continue flow of code

```java
import java.util.Random;

class TMSHandleError{
    public static void main(String[] args) {
        int a =0,b=0,c=0,i=0;

        Random r = new Random();
        for(i = 0;i< 1000;++i)
        {
            try{
                b = r.nextInt();
                c = r.nextInt();
                System.out.println("b = "+b);
                System.out.println("c = "+c);

              
                a = 23456/(b/c); // c gt than b ==> 0 ===> Exception
            }
            catch(ArithmeticException ae){

                System.out.println("Exception Divide by Zero occurred . ");
                a = 0;
            }
            System.out.println("Printing a : "+ a);
            System.out.println("\n\n---------");
       
        }
    }
}
```

- When you use **multiple catch** statements, exception
subclasses must come before any of their superclasses. 
subclass would never be reached if it came after its superclass if superclass used before subclasses ,Unreachable code is an error.

```java
// NESTED TRY CODE
public class CodeNestedTry{

    public static void main(String[] args) {
        try {
            int a = args.length;

            int b = 34 / a;
            System.out.println("a =  " + a);
            try {
                if (a == 1) {
                    a = a / (a - a); // divide by zero error
                }
                if (a == 2) {
                    int c[] = {};
                    c[44] = 122;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("In catch ArrayIndexOutOfBoundsException " + e);
            }
        } catch (ArithmeticException e) {
            System.out.println("In catch  ArithmeticException : Divide by 0" + e);
        }

        System.out.println("After try catch block");

    }
}
```

> ### ***throw , throws ,finally***
- ### **throw**
```java
// to throw an exception explicitly, using the throw statement.

    // throw throwableInstance;
    throw new NullPointerException("any string");
    // Many of Java’s built-in run-time exceptions have at least two constructors: one with no parameter and one that takes a string parameter.

   class ThrowUse{
    static void method1()
    {
        try
        {
            throw new NullPointerException("Inside method1");

        }
        catch(NullPointerException npe){
            System.out.println("In method1 catch");
            throw npe;
        }
    }


    public static void main(String[] args) {
        System.out.println("In main");
        try {
            method1();
        } catch (NullPointerException e) {
            System.out.println("In main : catch block ");
        System.out.println("Print e "+e);
        }
    }    
}

```

> ### **throws**

- if any method(function) has chances to create exceptions then all those exceptions need to handle either outside or inside method
- If method does not handle it ,Caller has to handle it. 
- To ask caller to guard with such exception, while writing method use throws keyword and declare exceptions-list(except Error and RuntimeExceptio n subclasses of it)
- exception-list is a comma-separated list of the exceptions that a method can throw.
> ReturnType ***MethodName***(parameter) throws exception-list
{ // code here}
```java
// EX. 1
/*
class ThrowsUse{
    static void method2()
    {
        System.out.println("In method2()");
        throw new ClassNotFoundException("demo"); // unreported exception ClassNotFoundException; must be caught or declared to be thrown  
    }
    public static void main(String[] args) {
        System.out.println("In main");
            method2();
    }    
}
*/

// This is now correct.
class ThrowsDemo {
static void throwOne() throws IllegalAccessException {
System.out.println("Inside throwOne.");
throw new IllegalAccessException("demo");
}
public static void main(String args[]) {
    try {
        throwOne();
    } catch (IllegalAccessException e) {
        System.out.println("Caught " + e);
    }
}
}
```
---
```java
// Ex 2 : Base64 to original file format conversion and save  with Throws ex.
import java.util.Base64;
import java.util.Base64.Decoder;
import java.io.FileOutputStream;
import java.io.IOException;


class Base64Util{
    public static void main(String[] args) throws IOException {
        System.out.println("In main()");

        Base64Util base64Util= new Base64Util();
        String getPath = base64Util.convertToOriginal("<base64 data with content type>");
       

        System.out.println("Path of file"+getPath);
    }
    public String convertToOriginal(String base64) throws IOException  {
        String extension = base64.substring(base64.indexOf("/") + 1, base64.indexOf(";"));
		String[] parts = base64.split("[,]");
		base64 = parts[1];
        System.out.println("File : " + base64);
        
        String path = "/tmp/tmsfile."+extension;
    
            // get decoder
            Decoder decoder = Base64.getDecoder();
            // convert base64 to byte array to pass data in output stream
            byte[] bytes = decoder.decode(base64);
            FileOutputStream fo = new FileOutputStream(path);
            // write data in o/p stream
            fo.write(bytes);
            // close the stream
            fo.close();
            System.out.println();
    
        // path which has written byte[]
        return path;
    }

}

```

>### **finally**
 - if exception throws and method handled it in such a way that returning prematurely then for some operations it is problematic situation
- ex. if file opened to write something,it has to be close later,but exception raised and premature return happened then file will remain open
-  finally introduced to handle such contigency


- Important from book
    > - finally creates a block of code that will be executed after a try/catch block has completed and before the code following the try/catch block. 
    > - The finally block will execute whether or not an exception is thrown. If an exception is thrown, the finally block will execute even if no catch statement matches the exception.
    > - Any time a method  is about to return to the caller from inside a try/catch block, via an uncaught exception or an explicit return statement, the finally clause is also executed just before the method returns. 
    > - This can be useful for closing file handles and freeing up any other resources that might have been allocated at the beginning of a method with the intent of disposing of thembefore returning.
    > - The finally clause is optional. However, each try statement requires at least one catch or a finally clause.

```java
    // Demonstrate finally.
class FinallyDemo {
    // Through an exception out of the method.
    static void procA() {
        try {
            System.out.println("inside procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("procA's finally");
        }
    }

    // Return from within a try block.
    static void procB() {
        try {
            System.out.println("inside procB");
            return;
        } finally {
            System.out.println("procB's finally");
        }
    }

    // Execute a try block normally.
    static void procC() {
        try {
            System.out.println("inside procC");
        } finally {
            System.out.println("procC's finally");
        }
    }

    public static void main(String[] args) {
        try{
            procA();
        }
        catch(Exception e){
            System.out.println("catch procA 's exception");
        }
        procB();;
        procC();
    }
}
/* OUTPUT
 inside procA
procA's finally
catch procA 's exception
inside procB
procB's finally
inside procC
procC's finally



note : The finally clause is executed before procB( ) returns
 */
 ```

 
> Checked vs Unchecked Exceptions
- Those exception which ***compiler does not check to see if method handles or throws these exceptions*** are called __Uncheck exceptions__
- Subclasses of RuntimeExceptions are uncheck exceptions as it is not included in any method's throws list
- java.lang also has exceptions that must included in methods throws list
are called **Checked Exceptions**

---

> ### **Creating Your Own Exception**

- To handle situation specific to some application , specific exceptions are needed.
- To defining subclass of Exception 
- All exceptions defined by throwable can be used by all exceptions

- Exception  defines four constructors . two added in JDK1.4

    - Exception();
    - Exception(String description);
-  For cleaner output , Overriding toString() is prefered over using second constructor with description
- because default to string displays the name of the exception followed by a colon, which is then followed by your description.

```java

// Userdefined exception
// in UserException.java

class UserException extends Exception{
    private int details;

    UserException(int a)
    {
        this.details = a;
    }

    public String toString() {
        return "USER EXCEPTION : "+this.details;
    }
}
```

```java
// In CallerUserException.java
public class CallerUserException {
    static void compute(int a) throws UserException {
        System.out.println("In compute function");
        if (a > 10)
            throw new UserException(a);

        System.out.println("Normal exit");
    }

    public static void main(String[] args) {
        try {
            compute(9);
            compute(11);

        } catch (UserException ue) {
            System.out.println("Caught : " + ue);
        }
    }

}

/*
 *  OUTPUT :
 In compute function
Normal exit
In compute function
Caught : USER EXCEPTION : 11
 */

```


> ### Chained exceptions : 
-  Feature that allows you to associate second exception with first exception.
where second exception describes the cause of first exception

    - Throwable(Throwable causeExc)
    - Throwable(String msg, Throwable causeExc)

- two methods commonly used for this
    - Throwable getCause( )
    - Throwable initCause(Throwable causeExc)


- steps
    - create an exception
    -  add a cause using initCause()
    - throw 
```java

    // Demonstrate exception chaining.
class ChainExceptionDemo {
    static void demoproc() {
        // create an exception
        NullPointerException e = new NullPointerException("top layer");
        // add a cause
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }

    public static void main(String args[]) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            // display top level exception
            System.out.println("Caught: " + e);
            // display cause exception
            System.out.println("Original cause: " +
                    e.getCause());
        }
    }
}
```

>  ### One last point: 
- Java’s exception-handling statements should not be considered a general mechanism for nonlocal branching. If you do so, it will only confuse your code and make it hard to maintain.

                        Exception Handling Ends ...
---
