package main.java.worker;

public class Converter {
	public Long toLong(String sku) {
		try {
			System.out.println(sku);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Long.valueOf(sku);
	}

	public Integer toInteger(Long sku) {
		try {
			System.out.println(sku);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(String.valueOf(sku));
	}

	public String toString(Integer sku) {
		try {
			System.out.println(sku);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(sku);
	}
}
