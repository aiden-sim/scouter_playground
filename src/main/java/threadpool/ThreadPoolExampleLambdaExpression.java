package threadpool;

import worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

// Runnable (caller 연결 O)
// scouter option
// hook_service_patterns=threadpool.ThreadPoolExampleLambdaExpression.main
public class ThreadPoolExampleLambdaExpression {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Executor executor = Executors.newFixedThreadPool(4,
				runnable -> {
					Thread thread = new Thread(runnable);
					thread.setDaemon(true);
					return thread;
				});

		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			return null;
		}, executor);

		future.get();
	}
}
