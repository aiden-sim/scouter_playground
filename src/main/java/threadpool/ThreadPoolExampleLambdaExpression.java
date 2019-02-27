package threadpool;

import worker.WorkerThread;

import java.util.concurrent.*;

// Runnable (caller 연결 X)
// scouter option
// hook_service_patterns=threadpool.ThreadPoolExampleLambdaExpression.main
public class ThreadPoolExampleLambdaExpression {
	private final static Executor executor = Executors.newFixedThreadPool(4,
			runnable -> {
				Thread thread = new Thread(runnable);
				thread.setDaemon(true);
				return thread;
			});

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadPoolExampleLambdaExpression ex = new ThreadPoolExampleLambdaExpression();
		ex.run();
	}

	public void run() throws ExecutionException, InterruptedException {
		CompletableFuture<Void> cf = CompletableFuture.runAsync(
				() -> {
					new WorkerThread().run();
				},
				executor
		);
		System.out.println(cf.get());
	}
}
