package demo;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncDemo {

	@Async
	public void method1() {
		System.out.println("Start Method1 AsyncDemo   ...   " + Thread.currentThread().getName());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End Method1 AsyncDemo   ...   " + Thread.currentThread().getName());
	}

	@Async
	public Future<String> method2() {
		String s = "Starting...";
		System.out.println("Start Method2 AsyncDemo   ...   " + Thread.currentThread().getName());
		try {
			Thread.sleep(50);
			s += "Sleep Over...";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End Method2 AsyncDemo   ...   " + Thread.currentThread().getName());
		return new AsyncResult<String>(s + "Complete   ...   ");
	}
}