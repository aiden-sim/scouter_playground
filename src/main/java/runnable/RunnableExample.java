package main.java.runnable;

import main.java.worker.WorkerRunnableThread;

public class RunnableExample {
	public static void main(String[] args) {
		Runnable runnable = new WorkerRunnableThread();
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
