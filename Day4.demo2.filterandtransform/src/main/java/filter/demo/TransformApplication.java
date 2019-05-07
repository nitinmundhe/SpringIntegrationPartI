package filter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages="demo")
@ImportResource("filter.xml")
public class TransformApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformApplication.class, args);
	}

}
