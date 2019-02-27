package worker;

public class WorkerThread {
	public void run() {
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
