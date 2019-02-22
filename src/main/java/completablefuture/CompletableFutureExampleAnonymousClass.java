package completablefuture;

import worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// Runnable (caller 연결 O)
// scouter option
// hook_service_patterns=completablefuture.CompletableFutureExampleAnonymousClass.main
// hook_async_callrunnable_scan_package_prefixes=completablefuture
public class CompletableFutureExampleAnonymousClass {
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
