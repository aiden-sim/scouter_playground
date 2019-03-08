package service;

// hook_service_patterns=service.Service.main
public class Service {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(5000);
		run();
	}

	public static void run() {
		System.out.println("run");
	}
}