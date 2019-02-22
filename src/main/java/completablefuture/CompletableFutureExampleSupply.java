package completablefuture;

import worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

// Supplier (caller 연결 X)
// scouter option
// hook_service_patterns=completablefuture.CompletableFutureExampleSupply.main
// hook_async_callrunnable_scan_package_prefixes=completablefuture
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
