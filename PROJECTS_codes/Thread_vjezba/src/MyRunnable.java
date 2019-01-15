
public class MyRunnable implements Runnable{

	@Override
	public void run() {
		
		go2();
	}

	private void go2() {
	
		go3();
	}

	private void go3() {
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		goaaaaaaa();
		
	}

	private void goaaaaaaa() {
		
		go();
	}

	private void go() {
		
		System.out.println("Ja sam PRVI thread");
	}

}
