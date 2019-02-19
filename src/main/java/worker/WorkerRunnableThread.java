package main.java.worker;

public class WorkerRunnableThread implements Runnable {
	@Override public void run() {
		doSomething();
	}

	public void doSomething() {
		try {
			System.out.println("doSomething");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
