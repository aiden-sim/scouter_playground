package main.java.completablefuture;

import main.java.worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExampleLamdbdaExpression {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			new WorkerThread().run();
		});
		future.get();
	}
}
