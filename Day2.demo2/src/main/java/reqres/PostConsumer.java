package reqres;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostConsumer {
	public static void main(String[] args) {
		String url = "https://reqres.in/api/user/2";
		RestTemplate template = new RestTemplate();
		template.setInterceptors(Collections.singletonList(new MyInterceptor2()));
		User u = new User();
		u.setName("Syn");
		u.setJob("Comp");
		HttpEntity<User> entity = new HttpEntity<User>(u);
		ResponseEntity<String> str = template.postForEntity(url, entity, String.class);
		System.out.println("Returned" + str);
	}
}