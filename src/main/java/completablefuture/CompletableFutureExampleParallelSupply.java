package main.java.completablefuture;

import main.java.worker.WorkerThread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// Supplier
public class CompletableFutureExampleParallelSupply {

	private final static Executor executor = Executors.newFixedThreadPool(4,
			runnable -> {
				Thread thread = new Thread(runnable);
				thread.setDaemon(true);
				return thread;
			});

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// CASE 1
		CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
			@Override
			public Long get() {
				new WorkerThread().run();
				return 0L;
			}
		});

		Long result = future.get();


		// Case2
		CompletableFutureExampleParallelSupply ex = new CompletableFutureExampleParallelSupply();
		ex.run();
	}

	public void run() {
		List<String> skuList = Arrays.asList("1111", "2222", "3333", "4444");
		final List<CompletableFuture<String>> futures = skuList.stream()
				.map(sku -> CompletableFuture.supplyAsync(() -> {
					return toLong(sku);
				}, executor))
				.map(future -> future.thenCompose(sku -> CompletableFuture.supplyAsync(() -> {
					return toInteger(sku);
				}, executor)))
				.map(future -> future.thenCompose(sku -> CompletableFuture.supplyAsync(() -> {
					return toString(sku);
				}, executor)))
				.collect(Collectors.toList());

		final List<String> skuResultList = futures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());

	}

	private Long toLong(String sku) {
		try {
			System.out.println(sku);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Long.valueOf(sku);
	}

	private Integer toInteger(Long sku) {
		try {
			System.out.println(sku);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(String.valueOf(sku));
	}

	private String toString(Integer sku) {
		try {
			System.out.println(sku);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(sku);
	}
}
