package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.export.annotation.ManagedResource;

@SpringBootApplication
@ImportResource("mmt-working.xml")
@EnableMBeanExport(defaultDomain="mmtMBean")
public class MMTApplication {
	public static void main(String[] args) {
		SpringApplication.run(MMTApplication.class, args);
		while(true) {			
		}
	}
}