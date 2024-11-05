#### **Inter-thread communication : `wait()`,`notify()`,`notifyAll`**
- specifically for managing thread synchronization when one thread needs to wait for another thread to perform some action. 
- part of the Object class, so every object in Java can be used as a monitor for synchronization purposes.

- `wait()`:
    - The `wait()` method causes the current thread to release the lock it holds on the object and to enter the waiting state.
    - Remain in the waiting state until another thread sends a notification (either via notify() or `notifyAll`), or until a specified timeout occurs (if using wait(long timeout)).
    - Programmer must call wait() inside a synchronized block or method because it requires the thread to hold the lock on the object it is calling wait() on.
- `notify()` :
    - `notify()` method wakes up one thread that is waiting on the object’s monitor (i.e., on `wait()`).
    - If multiple threads are waiting, `notify()` will wake up one of them arbitrarily. If no threads are waiting, the call to `notify()` has no effect.
- `notifyAll` :
    -  wakes up all the threads that are waiting on the object’s monitor.
    -  useful when multiple threads are waiting for a condition to change and you want to wake up all of them to re-check their conditions.

## EXAMPLE:
```java

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 10;

    // Producer method
    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer full, producer is waiting...");
            wait(); // Wait until there is space in the buffer
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); // Notify any waiting consumer threads
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty, consumer is waiting...");
            wait(); // Wait until there is something to consume
        }
        int item = buffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll(); // Notify any waiting producer threads
        return item;
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                buffer.produce(i);
                Thread.sleep(100); // Simulate some delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                buffer.consume();
                Thread.sleep(150); // Simulate some delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

```
----

#### `volatile` keyword