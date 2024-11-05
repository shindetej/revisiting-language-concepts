package come.tejas.demo;

import java.util.Random;

public class Producer implements Runnable {
	private String name;

	public Producer(String name) {
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
		Random r = new Random();
		try {
			while (true) {
				/*
				 * synchronized (lockObject) { // critical section code }
				 */
				synchronized (TestMain.bucket) {
					if (TestMain.bucket.size() < 100) {
						int n = r.nextInt(1000);// [0,999] random number
						TestMain.bucket.add(n);
						TestMain.bucket.notifyAll();
						System.out.println(
								"THREAD " + Thread.currentThread().getName() + " ADDED  VALUE " + n + "TO BUCKET");
					} else {
						TestMain.bucket.wait();
					}
				}

			}
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}

}
