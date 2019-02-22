package threadpool;

import worker.WorkerRunnableThread;
import worker.WorkerThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Runnable (caller 연결 O)
// scouter option
// hook_service_patterns=threadpool.ThreadPoolExample.main
public class ThreadPoolExample {
	public static void main(String[] args) {
		// CASE1
		// hook_async_callrunnable_scan_package_prefixes=worker
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new WorkerRunnableThread());
		executorService.shutdown();

		// CASE2
		// hook_async_callrunnable_scan_package_prefixes=threadpool
		ExecutorService executorService2 = Executors.newFixedThreadPool(5);
		executorService2.execute(new Runnable() {
			@Override public void run() {
				new WorkerThread().run();
			}
		});
		executorService2.shutdown();
	}
}
