
public class ThreadTester {

	public static void main(String[] args) {
		
		

		Runnable r = new MyRunnable();
		Runnable r2 = new MyRunnable2();
		Thread prviThread = new Thread(r);
		Thread drugiThrad = new Thread(r2);


		System.out.println("Ja sam MAIN thread iznad");
		
		
		
		prviThread.start();
		drugiThrad.start();


		System.out.println("Ja sam MAIN thread ispod");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("aaa");
		System.out.println("");



		
	}

}
