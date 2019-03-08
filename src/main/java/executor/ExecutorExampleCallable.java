package executor;

import worker.WorkerCallableThread;
import worker.WorkerThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Callable (caller 연결 O)
// scouter option
// hook_service_patterns=executor.ExecutorExampleCallable.main
public class ExecutorExampleCallable {
	private final static String EMPTY = "";

	public static void main(String[] args) {
		// CASE1
		// hook_async_callrunnable_scan_package_prefixes=worker
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(new WorkerCallableThread());
		executorService.shutdown();

		// CASE2
		// hook_async_callrunnable_scan_package_prefixes=executor
		ExecutorService executorService2 = Executors.newFixedThreadPool(1);
		executorService2.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				new WorkerThread().run();
				return EMPTY;
			}
		});
		executorService2.shutdown();
	}
}
