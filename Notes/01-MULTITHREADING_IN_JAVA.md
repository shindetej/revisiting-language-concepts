#### **What kind of multithreading used in real time application of java**

In real-world Java multithreading applications, several methods and techniques are commonly used to manage and work with threads effectively. Here are some of the most frequently used methods and techniques:

1. **Thread Creation**:
   - `Thread` class constructor: Creating new threads by instantiating the `Thread` class.
   - `Runnable` interface: Implementing the `Runnable` interface and passing it to a `Thread` constructor for thread creation.
   - `ExecutorService`: Using the `java.util.concurrent.ExecutorService` framework for thread management and pooling.

2. **Thread Start and Termination**:
   - `start()`: Starting a thread's execution.
   - `run()`: Overriding the `run()` method to define the thread's logic.
   - `join()`: Waiting for a thread to finish its execution.
   - `interrupt()`: Interrupting a thread's execution.

3. **Thread Synchronization**:
   - `synchronized` keyword: Synchronizing methods or code blocks to ensure exclusive access to shared resources.
   - `wait()`, `notify()`, and `notifyAll()`: Coordinating threads using object monitors for inter-thread communication.
   - `Lock` and `Condition`: Using the `java.util.concurrent.locks` package for more advanced synchronization.

4. **Thread Safety**:
   - `volatile` keyword: Marking variables as `volatile` to ensure visibility of changes across threads.
   - `Atomic` classes: Utilizing classes like `AtomicInteger`, `AtomicLong`, and `AtomicReference` for atomic operations.

5. **Thread Communication**:
   - `BlockingQueue`: Using blocking queues for thread-safe data exchange between producer and consumer threads.
   - `CountDownLatch` and `CyclicBarrier`: Synchronizing multiple threads at specific points in their execution.

6. **Thread Control**:
   - `ExecutorService` and `ThreadPoolExecutor`: Managing thread pools for efficient resource utilization.
   - `ScheduledExecutorService`: Scheduling tasks to run periodically.
   - `Future` and `CompletableFuture`: Getting results from asynchronous tasks.

7. **Thread Local Storage**:
   - `ThreadLocal`: Storing thread-specific data without interference from other threads.

8. **Error Handling**:
   - Properly handling exceptions within threads and propagating them to the appropriate context.

9. **Thread Grouping and Prioritization**:
   - `ThreadGroup`: Organizing threads into groups for easier management.
   - Setting thread priorities using `setPriority()`.

10. **Concurrency Utilities**:
    - Utilizing the various utilities provided by the `java.util.concurrent` package, such as `Semaphore`, `Barrier`, and `ConcurrentHashMap`, for specific concurrency needs.

11. **Atomic Operations**:
    - Using atomic operations like `compareAndSet()` in `Atomic` classes to perform thread-safe updates.

12. **Parallel Streams**:
    - Leveraging Java's Stream API for parallel processing of data.

13. **Fork-Join Framework**:
    - Using the `java.util.concurrent.ForkJoinPool` for parallel processing of recursive algorithms.

14. **Thread Safety Patterns**:
    - Applying common thread safety patterns like Singleton, Double-Checked Locking, and Immutable Objects.

15. **Monitoring and Profiling**:
    - Utilizing tools like JVisualVM, Java Mission Control, and custom logging to monitor and profile thread behavior and performance.


---


#### **NOTES OF MULTITHREADING IN JAVA**

-  Why Multithreading Comes into Picture?
    - applications often have tasks or operations that can be done at the same time without waiting for each other to finish.
    - Multithreading comes into the picture to make the most of a computer's processing power by allowing multiple threads (like those chefs) to run concurrently. 
    - In Java, multithreading is especially important because it lets you create applications that are more responsive, efficient, and capable of handling tasks in parallel. You can use it to perform background tasks, improve user interface responsiveness, and utilize modern multicore processors effectively.
    - So, in essence, multithreading allows a Java application to juggle multiple tasks simultaneously, making it more efficient and responsive to user needs.
    ---
3) How synchronization doen in multithreaded application of java
explain with example
    - In Java, synchronization is a technique used to ensure that multiple threads don't access shared resources (like variables or objects) simultaneously in a way that could lead to data corruption or unexpected behavior. The primary mechanism for achieving synchronization is the `synchronized` keyword and the use of locks (implicit or explicit) to control access to critical sections of code. Let me explain with an example.

    - Suppose we have a simple bank account class with two methods: `deposit` and `withdraw`, and we want to ensure that these methods are thread-safe to prevent issues when multiple threads access the account concurrently.

    ```java
    public class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // This method allows a thread to deposit money into the account.
        public synchronized void deposit(double amount) {
            balance += amount;
        }

        // This method allows a thread to withdraw money from the account.
        public synchronized void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Insufficient balance.");
            }
        }

        // This method returns the current balance.
        public synchronized double getBalance() {
            return balance;
        }
    }
    ```
    - In this example:

        1. We use the `synchronized` keyword in the `deposit` and `withdraw` methods. This means that only one thread can execute these methods at a time. Other threads trying to access these methods will be blocked until the current thread finishes.

        2. This ensures that deposits and withdrawals are atomic operations. Atomicity means that each operation completes fully before another thread can access the method, preventing race conditions where multiple threads could potentially interfere with each other.

    - Here's a simple example of how you might use this `BankAccount` class in a multithreaded Java application:

    ```java
    public class Main {
        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000);

            Thread thread1 = new Thread(() -> {
                account.deposit(200);
                account.withdraw(300);
            });

            Thread thread2 = new Thread(() -> {
                account.deposit(100);
                account.withdraw(150);
            });

            thread1.start();
            thread2.start();

            // Wait for both threads to finish
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final balance: " + account.getBalance());
        }
    }
    ```
    - two threads are concurrently depositing and withdrawing money from the same account
---




## B. **11th Chapter of Java complete reference**
---
- process-based multitasking is not under the control of Java. However, multithreaded multitasking is.

> **TOPIC**  
1)   Thread model 
2)   Create a thread - using runnable interface and Extending Thread class,which is preferred , creating multiple threads.
3)  Using isLive() and Join
4)  Synchronization and synchronized statement
5)  Deadlock related.
6)  Suspend ,Resuming and Stopping Threads With newer method 
---
> 2. Create thread implementing runnable interface and run two threads (main and created thread)
---
-  Important note : 
    
    - At this point, you might be wondering why Java has two ways to create child threads, and which approach is better. The answers to these questions turn on the same point. 
    - The Thread class defines several methods that can be overridden by a derived class. Of these methods, the only one that must be overridden is run(). 
    - This is, of course, the same method required when you implement Runnable. Many Java programmers feel that classes should be extended only when they are being enhanced or modified in some way. 
    - So, if you will not be overriding any of Thread’s other methods, it is probably best simply to implement Runnable. This is up to you, of course.
---
```java
public class NewThread implements Runnable {
    Thread thread;

    NewThread() {
        // create new , second thread
        thread = new Thread(this, "Demo Thread");
        System.out.println("Child thread : " + thread);
        thread.start(); // start a thread
    }

    @Override
    public void run() {
        System.out.println("IN :  CHILD THREAD");
        try{
            for(int i=0 ;i<10; ++i)
            {
                System.out.println("In Child thread : "+ i);
                 Thread.sleep(1000);                  
            }
        }
        catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }

        System.out.println("OUT :  CHILD THREAD");
    }

}

```

```java
public class NewThreadMain {

    public static void main(String[] args) {
        System.out.println("IN :  main THREAD");
         
        try {
            for(int i=30 ;i<40; ++i)
            {
                System.out.println("In Main thread : "+ i);
                 Thread.sleep(2000);                  
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception In Main Thread  ");
        }

        System.out.println("OUT :  main THREAD");
    }
}
```
- Create thread extending Thread class and run two threads (main and created thread)

```java
public class NewThread extends Thread {

    NewThread() {
        // create new , second thread
        super("Demo Thread");
        System.out.println("Child thread : ");
        start(); // start a thread
    }

    @Override
    public void run() {
        System.out.println("IN :  CHILD THREAD");
        try {
            for (int i = 0; i < 10; ++i) {
                System.out.println("In Child thread : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }

        System.out.println("OUT :  CHILD THREAD");
    }
}

// main class is same as in runnable interface code
// output
IN :  main THREAD
Child thread : 
In Main thread : 30
IN :  CHILD THREAD
In Child thread : 0
In Child thread : 1
In Main thread : 31
In Child thread : 2
In Child thread : 3
In Main thread : 32
In Child thread : 4
In Child thread : 5
In Main thread : 33
In Child thread : 6
In Child thread : 7
In Main thread : 34
In Child thread : 8
In Child thread : 9
In Main thread : 35
OUT :  CHILD THREAD
In Main thread : 36
In Main thread : 37
In Main thread : 38
In Main thread : 39
OUT :  main THREAD
```

-  ***creating multiple threads***
```java 
public class NewThread implements Runnable {
    Thread thread;
    String name;


    NewThread(String threadName) {
        this.name =  threadName;
        // create new , second thread
        thread = new Thread(this, name);
        System.out.println("New thread : " + thread);
        thread.start(); // start a thread
    }

    @Override
    public void run() {
        System.out.println("IN :  "+name+" THREAD");
        try{
            for(int i=0 ;i<10; ++i)
            {
                System.out.println("In : "+name + ": "+ i);
                 Thread.sleep(1000);                  
            }
        }
        catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }

        System.out.println("OUT : "+name+" THREAD");
    }

}

```

```java
public class NewThreadMain {

    public static void main(String[] args) {
        System.out.println("IN :  main THREAD");
         new NewThread("Tejas");
         new NewThread("Mayur");
         new NewThread("Tyagi");
        try {
            for(int i=30 ;i<40; ++i)
            {
                System.out.println("In Main thread : "+ i);
                 Thread.sleep(2000);                  
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception In Main Thread  ");
        }

        System.out.println("OUT :  main THREAD");
    }
}


```


---
## B. ***FROM LAUR SPILCA Youtube channel***
> Multithreading why? my understanding
-  seperate/independent execution lifecycle of some instructions needed which is independent of current thread(execution)
- to improve performance of application with optimized usage of cpu(via JVM)
- enable your application to use all/most of cores of cpu



> Extending Thread & Runnable Implementation
- Extending Thread not used on actual ground but for better understanding 
- run method has set of instruction to run in that thread



```java

package main;

// by extending thread class you basically create thread  
// any instance is seperate thread   
// when we want seperate instruction set running  
// i.e seperate timeline of execution independent of main thread 
public class EvenNumbersThread extends Thread{

   // individual thread starts with run method 
   @Override
   public void run(){
    for(int i = 0; i<=10;i+=2){
        System.out.println(i)
    }
   }
}
```

```java
package main;

public class Main{

    // application starts with main method
    public static void main(String []args)
    {
        EvenNumbersThread t1 =  new EvenNumbersThread();
        t1.start();
        t1.start(); // EXCEPTION !!!
        SOP("END");
    }
}
```
> explained - thread life cycle in simple words
    
    - New State
    - Runnable state
    - Running state
    - Blocking state
    - Dead state



>  **t1.start() vs t1.run()**
- start() is a method defined in the Thread class.
- When you call t1.start(), it creates a new thread of execution for the instance t1.
- The new thread will invoke the run() method of the t1 instance in a separate execution context.
- This allows for concurrent execution of code. The run() method is executed concurrently with the main program or other threads if multiple threads are used.
- It provides true multithreading and is the preferred way to start a new thread in Java.


- run() is a regular method defined in your class that extends Thread or implements Runnable.
- When you call t1.run(), it does not create a new thread; instead, it simply executes  in the current thread
- There is no concurrent execution; it's essentially a regular method invocation.
- not recommended if you want to run code concurrently.

---
```
 In practice, **using the Runnable interface** is often considered a better practice for multithreading because it promotes better **separation of concerns**. You can create a separate Runnable object that encapsulates the task to be performed by the thread, and then you can pass this object to multiple threads if needed. This is particularly useful when you're working with thread pools, where you can reuse threads to execute different Runnable tasks.
```

So, while both approaches have their use cases, the Runnable interface is often preferred for its flexibility and better support for resource sharing. However, the choice ultimately depends on your specific requirements and design considerations.


> **About join()**

- Join() - thread must wait until caller thread finish its execution .

```java
package com.tejas.multithreading;

public class JoinExample {
	public static void main(String[] args) {
		try {
			// DB1 Query result takes 5 sec
			Thread t1 = new Thread(() -> {
				try {
					Thread.sleep(5000);
					System.out.println("In Thread t1's Runnable!!!");
					System.out.println("DB1 query result!!!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			// DB2 Query result takes 3 sec
			Thread t2 = new Thread(() -> {
				try {
					Thread.sleep(2000);
					System.out.println("In Thread t2's Runnable!!!");
					System.out.println("DB2 query result!!!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

			t1.start();
			t2.start();

//			t2.join(); // resume current execution when t2 threads completes execution after t2.start
//			t1.join(); // resume current execution when t1 threads completes execution after t1.start
			
			t2.join(100); // wait until t2 threads completes execution or 100ms whichever earlier
			System.out.println("###");
			t1.join(100);// wait until t1 threads completes execution or 100ms whichever earlier
			System.out.println("***");

			
			// Post processing on results of queries
			System.out.println("Post processing after DB");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
```

> **Synchronisation In Multithreading**

- create condition to explain why we required synchronization using Producer-Consumer Pattern
- (read about producer consumer pattern)
- When p1 and p2 are producers which are adding integer in bucket say Array list (not thread safe) 
- and c1 and c2 consumers consuming that i.e removing from bucket at same time

> see demo code 
1. Producer.java
```java
public class Producer implements Runnable {

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			if (Main.bucket.size() < 100) {
				int n = r.nextInt(1000); // [0-999]
				Main.bucket.add(n);
				System.out.println(Thread.currentThread().getName() + " added value " + n + " to the bucket");
			}
		}

	}

}
```
2. Consumer.java
```java
public class Consumer implements Runnable {
	public Consumer() {
	}
	@Override
	public void run() {

		Random r = new Random();

		while (true) {
			if (!Main.bucket.isEmpty()) {
				int n = Main.bucket.get(0);
				Main.bucket.remove(0);
				System.out.println(Thread.currentThread().getName() + " took out value " + n + " from the the bucket");
			}
		}
	}

}
```
3. Main.java
```java
public class Main {

	/**
	 * 
	 * ArrayList not synchronized
	 */
	public static List<Integer> bucket = new ArrayList<>();

	public static void main(String[] args) {
		Thread threadProducer1 = new Thread(new Producer(), "P1");
		Thread threadProducer2 = new Thread(new Producer(), "P2");
		Thread threadConsumer1 = new Thread(new Consumer(), "C1");
		Thread threadConsumer2 = new Thread(new Consumer(), "C2");

		threadProducer1.start();
		threadProducer2.start();
		threadConsumer1.start();
		threadConsumer2.start();
		System.out.println("END");

	}

}
```

- there is condition when below exception comes
```
Exception in thread "C2" java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
```
- because c2 processing on  buckets last element and after empty check context switch done by JVM  then c1 removes last element  after retaining c1's old state c2 tries to remove element on empty bucket hence above exception comes

> **In these case synchronization between threads needed**

- Synchornised Consumer.java - run method
```java
	@Override
	public void run() {
		while (true) {
			synchronized (Main.bucket) {
				if (!Main.bucket.isEmpty()) {
					int n = Main.bucket.get(0);
					Main.bucket.remove(0);
					System.out.println(
							Thread.currentThread().getName() + " took out value " + n + " from the the bucket");
				}
			}
		}
	}

```
- Synchornised Producer.java - run method
```java
@Override
	public void run() {
		Random r = new Random();

		while (true) {
			synchronized (Main.bucket) {
				if (Main.bucket.size() < 100) {
					int n = r.nextInt(1000); // [0-999]
					Main.bucket.add(n);
					System.out.println(Thread.currentThread().getName() + " added value " + n + " to the bucket");
				}
			}
		}

	}
```
>  Use of wait()
- Although above changes are sychronized but there is boundary condition where we can improve performance
    - case 1 -when Consumer's run method get bucket empty 
        -  If bucket empty , removal(consumption) operation not able to perform so cpu time of this "thread in running context" can be utilized by other threads by sending current thread to blocked state until bucket is filled.
        - Here ***wait() is used to make a thread temporarily release the lock on bucket(monitoring object), allowing other threads to acquire the lock and perform their tasks.***
    - case 2 - when Producer's run method get bucket full

- wait() -  non-static method that belongs to the Object class i.e called on any object.
-  used within a synchronized block or method.
- **The thread calling wait() must hold the monitor (lock) on the object it's called on.**
- throws InterruptedException - if interrupted while waiting (any method that put running thread in blocked state throws InterruptedException) 
- waits  **until another thread notifies it using the notify() or notifyAll() method on the same object.**
- The wait() method has two forms:
    - wait(): This method causes the current thread to wait indefinitely until another thread calls notify() or notifyAll() on the same object.
    - wait(long timeout): This method causes the current thread to wait for the specified amount of time (in milliseconds) or until another thread calls notify() or notifyAll() on the same object, whichever occurs first.
--- 

Producer.java changes
```java
try {
			while (true) {

				synchronized (Main.bucket) {
					if (Main.bucket.size() < 100) {
						int n = r.nextInt(1000); // [0-999]
						Main.bucket.add(n);
						Main.bucket.notifyAll();
						System.out.println(Thread.currentThread().getName() + " added value " + n + " to the bucket");
					}
					else {
						Main.bucket.wait();
					}
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
```

Consumer.java changes
```java
while (true) {
			synchronized (Main.bucket) {
				if (!Main.bucket.isEmpty()) {
					int n = Main.bucket.get(0);
					Main.bucket.remove(0);
                    // notify after removed element 
					Main.bucket.notifyAll();
					System.out.println(
							Thread.currentThread().getName() + " took out value " + n + " from the the bucket");
				}
				else {
					Main.bucket.wait();
				}
			}
		}
```

---

## **JCR Chapter 28 : Java Concurrency Utilities**

> Java's Original Support for multithreading
-  Runnable Interface and Thread class
- synchronized for synchronization
- wait() and notify() for interthread communication

>  not ideal for intensive use of multithreaded applications
- no high level features like
    1. semaphores
    2. thread pools
    3. execution managers for managing concurrent programs

- examples of such programs
    - seperate threade simultaneously compute the partial results of large computation
    - program that coordinates activities of several thread each of it seeks access to database

> ***JDK 5 introduces Concurrency utilities***
> Fork/Join framework was important addition
- Enable the programs that make use multiple processors(like in multicore systems)
- True parallel execution instead of Just time-slicing
- More feature added to it in JDK 8

### java.util.concurrent
1. **Synchronizers**
    - high level way of sync the interactions between multiple threads
    > Important classes
    1. Semaphore
        - It is synchronization object which implements classic semaphore
        - Semaphore controls access to a shared resource by maintaining count called permits
            - to access resource thread must have permit from semaphore
            - if permits greater than zero access offered else
            - if count == 0 access is denied
        - **constructor** :
            1. Semaphore(int num) and variants
        - **methods** :
            1. acquire() & acquire(int num)
            2. release() & release(int num)
        - **uses** : limiting the number of database connections, protecting a critical section, or managing a fixed pool of resources
    > ### **code :  semaphore example**
    ```java
    package com.tms.example.semaphore;

    import java.util.concurrent.Semaphore;

    public class SemaphoreDemo {

        public static void main(String[] args) {
            // instance with permit count 1
            Semaphore sem = new Semaphore(1);

            Runnable inc = new IncThread("IncrementingThread", sem);
            Runnable dec = new DecThread("DecrementingThread", sem);
            // starting threads

            new Thread(inc).start(); 
            // Note : use join() on above thread if you want inc execute first every time
            new Thread(dec).start();
        }

    }

    // Shared resource
    class Shared {
        // Permits
        static int count = 0;
    }

    class IncThread implements Runnable {

        String name;
        Semaphore sem;

        IncThread(String name, Semaphore sem) {
            this.sem = sem;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Starting  : " + name);
            try {
                // get permit
                System.out.println(name + " waiting for a permit");

                sem.acquire();

                System.out.println(name + " acquired for a permit");

                // access shared resource
                for (int i = 0; i < 5; i++) {
                    Shared.count++;
                    System.out.println(name + " : " + Shared.count);
                    Thread.sleep(50);
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                // release the permit
                System.out.println(name + "releases the permit");
                sem.release();
            }

        }

    }

    class DecThread implements Runnable {
        String name;
        Semaphore sem;

        public DecThread(String name, Semaphore sem) {
            this.name = name;
            this.sem = sem;
        }

        @Override
        public void run() {

            System.out.println("Starting  : " + name);

            try {
                // get permit
                System.out.println(name + " waiting for a permit");

                sem.acquire();

                System.out.println(name + " acquired for a permit");

                // access shared resource
                for (int i = 0; i < 5; i++) {
                    Shared.count--;
                    System.out.println(name + " : " + Shared.count);
                    Thread.sleep(50);
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                // release the permit
                System.out.println(name + "releases the permit");
                sem.release();

            }
        }
    }

    /*
    Starting  : IncrementingThread
    IncrementingThread waiting for a permit
    Starting  : DecrementingThread
    IncrementingThread acquired for a permit
    DecrementingThread waiting for a permit
    IncrementingThread : 1
    IncrementingThread : 2
    IncrementingThread : 3
    IncrementingThread : 4
    IncrementingThread : 5
    IncrementingThreadreleases the permit
    DecrementingThread acquired for a permit
    DecrementingThread : 4
    DecrementingThread : 3
    DecrementingThread : 2
    DecrementingThread : 1
    DecrementingThread : 0
    DecrementingThreadreleases the permit
    */
    ```
    > example of producer and consumer sync
    ```java
    package com.tms.example.prodCon;

    import java.util.concurrent.Semaphore;

    public class Bucket {

        private int n;
        private static Semaphore semCon =  new Semaphore(0); // Initially set to no available permits
        private static Semaphore semProd =  new Semaphore(1); // Initially set to 1 permits
        
        public void get() {
            try {
                semCon.acquire(); // here semCon decrement by 1 
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            System.out.println("Got : "+ n);
            semProd.release(); // here semProd incremented by 1
        }
        
        public void put(int n) {
            try {
                semProd.acquire(); // here semCon decrement by 1 
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            this.n = n;
            System.out.println("Put : "+ n);
            semCon.release(); // here semProd incremented by 1
        }
        
    }

    /*
    * Put : 0
    Got : 0
    Put : 1
    Got : 1
    Put : 2
    Got : 2
    Put : 3
    Got : 3
    so on....
    */
 
    ```
        
    2. CountDownLatch
        - to wait thread until one or more events occured
        - CountDownLatch creates number of count.
        - The latch is released when the number of events that occurred matches that count.
        - **constructor:**
            - CountDownLatch(initialCount);
 **where num specifies number of event must occur to open the latch**
        - **method** : 
            - To wait on the latch
                1. void await( ) throws InterruptedException
                2. void await(long wait, TimeUnit tu) throws InterruptedException
            - To signal an event : 
                1. void countDown( )
                    - each call decrements the count associated with the invoking object
        > note that CountDownLatch is not designed for one-time use; once the count reaches zero, it cannot be reset.
        ```java
        package com.tms.example.cdl;

        import java.util.concurrent.CountDownLatch;

        public class MyThread implements Runnable {
            CountDownLatch latch;

            public MyThread(CountDownLatch cdl) {
                this.latch = cdl;
                
                // create thread and start running it
                new Thread(this).start();
            }

            @Override
            public void run() {
                
                for(int i = 0;i<4;++i) {
                    System.out.println("-->  "+i);
                    latch.countDown();
                }
            }
        }
      

        class MainCountDownLatch {
            public static void main(String[] args) {
                CountDownLatch cdl = new CountDownLatch(4);

                System.out.println("Starting with CountDownLatch set to 4 count");
                new MyThread(cdl);

                try {
                    cdl.await(); // wait main thread execution until latch is released
                } catch (InterruptedException e) {
                    System.out.println("Exception caught");
                }

                System.out.println("Count down latch released after count 0:  DONE ");
            }

        }
        /*
        * OUTPUT :
        * Starting with CountDownLatch set to 4 count
        -->  0
        -->  1
        -->  2
        -->  3
        Count down latch released after count 0:  DONE 
        * */
 
        ```
    3. Cyclic Barrier
        - similar to CountDownLatch, but with the ability to reset and reuse for multiple sets of tasks
        - **Constructor** : CyclicBarrier(parties);
        - **method** : 
            -  barrier.await();
            -  barrier.reset();
                - similar to CountDownLatch, but with the ability to reset and reuse for multiple sets of tasks
            - **used when a fixed number of threads need to synchronize at a predefined point before proceeding together.**

    4. Exchanger
        - **important** : designed
to simplify the exchange(swap) of data between two threads 
        - Exchanger is a generic class Exchanger<V>, where V is type of data to be exchanged
        - **method** : 
            1. V exchange(V buffer)  
                - buffer is a reference to the data to exchange
            2. V exchange(V buffer, long wait, TimeUnit tu)
        - a "rendezvous" refers to a specific point or event where two or more threads or processes meet and synchronize their activities. 
throws InterruptedException, TimeoutException
    5. Phaser
    - each synchronizer is solution to specific type of synchronization.

---

2. **Executors**
    - manages thread execution
    - top of hierarchy :  Executor
    - ExecutorService extends it 
    - top implementation of ExecuatorService:
        1. ThreadPoolExecutor
        2. ScheduledThreadPoolExecutor
        3. ForkJoinPool
    - Future nad Callable Interfaces (earlier used and explained)
---
3. **Concurrent collections**
    - ConcurrentHashMap
    - ConcurrentLinkedQueue
    - CopyOnWriteArrayList
---
4. **The Fork/Join Framework**
    - ForkJoinTask
    - ForkJoinPool
    - RecursiveTask
    - RecursiveAction
---
- Also it has TimeUnit Enumeration to better handle timing
- Flow Class has
    - Flow.Subscriber
    - Flow.Publisher
    - Flow.Processor
    - Flow.Subscription
- for above approach ... Data produced by Publisher , consumed by Subscriber and controlled by back pressure

### java.util.concurrent.atomic
- facilitates use of variable in concurrent environment
- effciently  **updating the value of variable without use of locks**
- classes used mainly for update
    1. AtomicInteger
    2. AtomicLong
- methods :
    1. CompareAndSet()
    2. decrementAndGet()
    3. getAndSet()


### java.util.concurrent.locks
- alternative to use of synchronized method
- Lock interface defines main mechanism used to acquire and relinquish
access to an object.
- Methods commonly used
    1. lock()
    2. unlock()
    3. tryLock()

---

