package main.java.threadpool;

import main.java.worker.WorkerRunnableThread;
import main.java.worker.WorkerThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Runnable
public class ThreadPoolExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new WorkerRunnableThread());
		executorService.shutdown();

		ExecutorService executorService2 = Executors.newFixedThreadPool(5);
		executorService2.execute(new Runnable() {
			@Override public void run() {
				new WorkerThread().run();
			}
		});
		executorService2.shutdown();
	}
}
