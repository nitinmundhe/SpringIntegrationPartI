import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Lab2Helper extends Thread {

	@Override
	public void run() {
		System.out.println("In start of Run " + new Date());
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In End of Run " + new Date());
	}
}

public class Lab2 {
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Print a number to continuew...");
		scanner.hasNextInt();
		
		System.out.println("In main " + new Date());
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		// Execute my code after 5 seconds
		// executor.schedule(new Lab2Helper(), 5, TimeUnit.SECONDS);
		
		// Delay is between two start time  
		//executor.scheduleAtFixedRate(new Lab2Helper(), 5, 1, TimeUnit.SECONDS);
		
		// Delay is between two end of previous and start of next 
		executor.scheduleWithFixedDelay(new Lab2Helper(), 5, 3, TimeUnit.SECONDS);
		scanner.close();
	}
}