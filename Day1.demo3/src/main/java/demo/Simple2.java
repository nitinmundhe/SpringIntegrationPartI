package demo;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Simple2 {

	@Scheduled( cron="*/5 * * * * *")
	public void m1(){
		System.out.println("Simple1 - m1 invoked   ...   "+ new Date()  + "  by " + Thread.currentThread().getName());
	}
	
	@Scheduled(initialDelay=4000, fixedRate = 4000)
	public void m2(){
		System.out.println("Simple1 - m2 invoked   ...   "+ new Date()  + "  by " + Thread.currentThread().getName());
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Scheduled(initialDelay=1000, fixedDelay = 3000)
	public void m3(){
		System.out.println("Simple1 - m3 invoked   ...   "+ new Date()  + "  by " + Thread.currentThread().getName());
	}
}
