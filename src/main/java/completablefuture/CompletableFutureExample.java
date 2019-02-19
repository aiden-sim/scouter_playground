package main.java.completablefuture;

import main.java.worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				new WorkerThread().run();
			}
		});
		future.get();
	}
}
