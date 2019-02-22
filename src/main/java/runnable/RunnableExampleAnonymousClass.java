package runnable;

import worker.WorkerThread;

// Anonymous (caller 연결 O)
// scouter option
// hook_service_patterns=runnable.RunnableExampleAnonymousClass.main
// hook_async_callrunnable_scan_package_prefixes=runnable
public class RunnableExampleAnonymousClass {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				new WorkerThread().run();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
