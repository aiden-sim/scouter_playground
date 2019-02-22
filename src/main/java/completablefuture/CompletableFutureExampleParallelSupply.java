package completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

// Supplier (caller 연결 O)
// scouter option
// hook_service_patterns=completablefuture.CompletableFutureExampleParallelSupply.main
// hook_async_callrunnable_scan_package_prefixes=completablefuture
public class CompletableFutureExampleParallelSupply {

	private final static Executor executor = Executors.newFixedThreadPool(4,
			runnable -> {
				Thread thread = new Thread(runnable);
				thread.setDaemon(true);
				return thread;
			});

	public static void main(String[] args) {
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

	public Long toLong(String sku) {
		try {
			System.out.println(sku);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Long.valueOf(sku);
	}

	public Integer toInteger(Long sku) {
		try {
			System.out.println(sku);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(String.valueOf(sku));
	}

	public String toString(Integer sku) {
		try {
			System.out.println(sku);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(sku);
	}
}
