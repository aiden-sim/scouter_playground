package worker;

import java.util.concurrent.Callable;

public class WorkerCallableThread implements Callable<String> {
	private final static String EMPTY = "";

	@Override public String call() {
		doSomething();
		return EMPTY;
	}

	private void doSomething() {
		try {
			System.out.println("doSomething");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
