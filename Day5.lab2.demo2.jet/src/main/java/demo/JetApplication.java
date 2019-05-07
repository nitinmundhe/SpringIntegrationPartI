package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "demo")
@EnableMBeanExport(defaultDomain="myMBean")
@ImportResource("jet.xml")
public class JetApplication {
	public static void main(String[] args) {
		SpringApplication.run(JetApplication.class, args);
	}
}