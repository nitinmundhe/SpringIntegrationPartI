package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ImportResource("AdaptorApplication-HTTP-current.xml")
@EnableJms
public class AdaptorApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdaptorApplication.class, args);
		while(true) {			
		}
	}
}