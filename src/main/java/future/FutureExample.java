package main.java.future;

import main.java.worker.WorkerCallableThread;
import main.java.worker.WorkerThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Callable
public class FutureExample {
	private final static String EMPTY = "";

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(new WorkerCallableThread());
		executorService.shutdown();

		ExecutorService executorService2 = Executors.newFixedThreadPool(5);
		executorService2.submit(new Callable<String>() {
			@Override public String call() throws Exception {
				new WorkerThread().run();
				return EMPTY;
			}
		});
		executorService2.shutdown();
	}
}
