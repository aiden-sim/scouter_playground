package threadpool;

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
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(
				()-> "Hello World!",
				executor
		);
		System.out.println(cf.get());
	}
}
