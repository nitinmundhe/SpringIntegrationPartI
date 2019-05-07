package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "demo")
@ImportResource("air.xml")
public class AirApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirApplication.class, args);
	}
}