package come.tejas.demo;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	// arraylist is not thread safe
	public static List<Integer> bucket = new ArrayList<>();

	public static void main(String[] args) {

		Producer p1 = new Producer("p1");
		Producer p2 = new Producer("p2");
		Consumer c1 = new Consumer("c1");
		Consumer c2 = new Consumer("c2");

		Thread tp1 = new Thread(p1, p1.getName());
		Thread tp2 = new Thread(p2, p2.getName());
		Thread tc1 = new Thread(c1, c1.getName());
		Thread tc2 = new Thread(c2, c2.getName());
		
		tp1.start();
		tp2.start();
		tc1.start();
		tc2.start();
	}
}
