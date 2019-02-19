package main.java.worker;

public class WorkerThread {
	public void run() {
		doSomething();
	}

	private void doSomething() {
		try {
			System.out.println("doSomething");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
