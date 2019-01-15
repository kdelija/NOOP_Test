
public class RunThread implements Runnable{

	public static void main(String[] args) {
		
		Runnable r1 = new RunThread();
		Runnable r2 = new RunThread();

		Thread thr1 = new Thread(r1);
		Thread thr2 = new Thread(r2);
		thr1.setName("Alpha1");
		thr2.setName("Beta2");
		thr1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thr2.start();
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			
			String threadName = Thread.currentThread().getName();
			System.out.println("This is thread " + i + ": " + threadName);
		}
	}

}
