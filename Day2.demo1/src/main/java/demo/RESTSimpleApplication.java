package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @ComponentScan
 * 		@Component
 * 			@Controller @Service @Repoository
 * 
 */
@SpringBootApplication(scanBasePackages="controllers")
public class RESTSimpleApplication {
	public static void main(String[] args) {
		SpringApplication.run(RESTSimpleApplication.class, args);
		//ApplicationContext ctx = SpringApplication.run(RESTSimpleApplication.class, args);
		//FirstController fc = (FirstController) ctx.getBean(FirstController.class);
		//fc.m1();
	}
}