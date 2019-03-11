package service;

// hook_service_patterns=service.Service2.main
// hook_method_patterns=service.Service2.doSomething
// hook_method_access_private_enabled=true
public class Service2 {
	public static void main(String[] args) throws InterruptedException {
		Service2 service = new Service2();
		service.doSomething();
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