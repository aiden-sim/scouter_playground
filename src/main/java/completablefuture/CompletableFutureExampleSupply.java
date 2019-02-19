package main.java.completablefuture;

import main.java.worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

// Supplier
public class CompletableFutureExampleSupply {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
			@Override
			public Long get() {
				new WorkerThread().run();
				return 0L;
			}
		});

		Long result = future.get();
	}
}
