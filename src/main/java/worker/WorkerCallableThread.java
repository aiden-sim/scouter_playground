package main.java.worker;

import java.util.concurrent.Callable;

public class WorkerCallableThread implements Callable<Long> {
	@Override public Long call() {
		doSomething();
		return 0L;
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
