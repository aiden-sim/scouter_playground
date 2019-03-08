package runnable;

import worker.WorkerRunnableThread;

// Runnable (caller 연결 O)
// scouter option
// hook_service_patterns=runnable.RunnableExample.main
// hook_async_callrunnable_scan_package_prefixes=worker
public class RunnableExample {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Thread.sleep(1000);
			Runnable runnable = new WorkerRunnableThread();
			Thread thread = new Thread(runnable);
			thread.start();
		}
	}
}
