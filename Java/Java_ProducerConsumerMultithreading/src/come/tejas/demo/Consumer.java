package come.tejas.demo;

import java.util.Random;

public class Consumer implements Runnable {
	private String name;

	public Consumer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
		while (true) {
			synchronized (TestMain.bucket) { // decide which is your monitor
				if (!TestMain.bucket.isEmpty()) {
					int n = TestMain.bucket.get(0);
					/*
					 * As arraylist is not synchronized it may happen one thread is at line 28 goes
					 * to runnable state and when came bucket may be empty due to other thread
					 * already removed it
					 */
					TestMain.bucket.remove(0);
					TestMain.bucket.notifyAll();
					System.out.println("THREAD " + Thread.currentThread().getName() + " CONSUMED(REMOVED)  VALUE " + n
							+ "  FROM  BUCKET");
				}else {
					TestMain.bucket.wait();
				}
			}

		}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
