package main.java.runnable;

import main.java.worker.WorkerThread;

// Runnable
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
