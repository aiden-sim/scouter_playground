package main.java.runnable;

import main.java.worker.WorkerThread;

// Lambda
public class RunnableExampleLambdaExpression {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			new WorkerThread().run();
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
