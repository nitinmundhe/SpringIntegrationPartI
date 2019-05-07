package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("demo1.xml")
public class StreamApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
		while(true) {			
		}
	}
}