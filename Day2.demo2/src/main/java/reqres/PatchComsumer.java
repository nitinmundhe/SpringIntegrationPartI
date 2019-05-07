package reqres;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class PatchComsumer {
	public static void main(String[] args) {
		String url = "https://reqres.in/api/user/2";
		RestTemplate template = new RestTemplate();
		template.setInterceptors(Collections.singletonList(new MyInterceptor()));
		User u = new User();
		u.setName("Syn");
		u.setJob("Comp");
		HttpEntity<User> entity = new HttpEntity<User>(u);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(1000);
		requestFactory.setReadTimeout(10000);
		template.setRequestFactory(requestFactory);
		ResponseEntity<String> str = template.exchange(url, HttpMethod.PATCH, entity, String.class);
		System.out.println("Returned" + str);
	}
}