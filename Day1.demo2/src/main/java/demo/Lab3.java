package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Lab3Helper implements Callable<Integer> {
	int num1 = 0;
	int num2 = 0;

	public Lab3Helper(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Addition of two number .. " + num1 + "," + num2);
		return num1 + num2;
	}
}

public class Lab3{
		public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		Lab3Helper helper1 = new Lab3Helper(10, 20);
		Future<Integer> ref1 = Executors.newSingleThreadExecutor().submit(helper1);
		System.out.println(ref1.get(10,TimeUnit.SECONDS));
		int a = 50;
		int b = 30;
		Callable<Integer> helper2 = () -> { return a - b;};		
		Future<Integer> ref2 = Executors.newSingleThreadExecutor().submit(helper2);
		System.out.println(ref2.get(10,TimeUnit.SECONDS));
	}
}