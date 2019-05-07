package apps;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import demo.AsyncDemo;
import demo.Simple1;


/***
 *  
 * @author nitin.mundhe
 * 
 * By Default ComponentScan base package is the one in which SpringBoot Application 
 * is present. 
 * 1. Either keep Application and component classes in same package 
 * 2. provide scanBasePackage property with component package name
 *
 * Basically you will get java.util.concurrent.RejectedExecutionException 
 * if your queue is full and pool size is also exhausted.
 * 
 * 
 */
@SpringBootApplication(scanBasePackages="demo")
public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ApplicationContext ctx = SpringApplication.run(Application.class,args);
		Simple1 simple = ctx.getBean(Simple1.class);
		for (int i = 1; i <= 5; i++) {
			System.out.println("i = "+i);
			simple.m1(i);
		}
		
		AsyncDemo demo = ctx.getBean(AsyncDemo.class);
		demo.method1();
		System.out.println("After main method 1");
				
		Future<String> fstr = demo.method2();
		System.out.println("After main method 2");
		System.out.println("Method 2 return value="+ fstr.get());
		
		System.out.println("End of main method  ...");
	}

	@Bean
	@Primary
	public TaskExecutor taskexe() {
		ThreadPoolTaskExecutor txe = new ThreadPoolTaskExecutor();
		txe.setCorePoolSize(1);
		txe.setMaxPoolSize(2);
		txe.setQueueCapacity(5);
		return txe;		
	}	
}
