package completablefuture;

import worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// Lambda (caller 연결 X)
// scouter option
// hook_service_patterns=completablefuture.CompletableFutureExampleLamdbdaExpression.main
// hook_async_callrunnable_scan_package_prefixes=completablefuture
public class CompletableFutureExampleLambdaExpression {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			new WorkerThread().run();
		});
		future.get();
	}
}
