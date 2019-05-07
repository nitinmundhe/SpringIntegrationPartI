import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class Lab1Helper implements Runnable {
	public Lab1Helper() {
		System.out.println("Lab1Helper Constructor!!!");
	}

	@Override
	public void run() {
		System.out.println("In Run of Lab 1 Helper!!!");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Out of Lab 1 Helper!!!");
	}
}

public class Lab1 {
	public static void main(String... args) {
		// Thread t1 = new Thread(new Lab1Helper());
		// t1.start();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Print a number to continuew...");
		scanner.hasNextInt();
		//Executor executor = Executors.newCachedThreadPool();
		/***
		 * Learnings
		 * If threads are efficient, then it may reuse the existing one else always create new one..
		 * So when we created 50 threads on JConsole we can see in total 62 threads ( 12 Intial )
		 * If we skip sleep meaning making threads more efficient then we can say around 25 or less then 62 threads 
		 * i.e. threads will be reused.
		 **  Cons :
		 *  can crash your system
		 */
		Executor executor = Executors.newFixedThreadPool(5);
		
		for (int i = 1; i <= 50; i++) {
			executor.execute(new Lab1Helper());
		}
		scanner.close();		
	}
}