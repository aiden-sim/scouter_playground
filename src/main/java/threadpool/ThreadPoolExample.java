package main.java.threadpool;

import main.java.worker.WorkerRunnableThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new WorkerRunnableThread());
		executorService.shutdown();
	}
}
