package test;

public class Myrunnable implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(true) {
			try {
				System.out.println("Hello");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception 
			}
		}
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Myrunnable());
		t1.start();
	}
}
