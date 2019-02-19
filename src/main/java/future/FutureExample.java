package main.java.future;

import main.java.worker.WorkerCallableThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(new WorkerCallableThread());
		executorService.shutdown();
	}
}
