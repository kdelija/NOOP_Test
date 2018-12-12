import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = null;
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Choose theme 1, 2 or 3");
		System.out.println("1 - LightVisualTheme");
		System.out.println("2 - DarkTheme");
		System.out.println("3 - SolarizedDarkTheme");
		System.out.print(": ");
		
		int i = sc.nextInt();
		
		if(i == 1) {
			
			client = new Client(new LightVisualTheme());
			
		} else if (i == 2) {
			
			client = new Client(new DarkTheme());
		} else if (i == 3) {
			
			client = new Client(new SolarizedDarkTheme());
		}
		
		sc.close();
	}

}
