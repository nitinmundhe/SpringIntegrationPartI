package transform.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages="transform.demo")
@ImportResource("transform.xml")
public class TransformApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransformApplication.class, args);
	}
}