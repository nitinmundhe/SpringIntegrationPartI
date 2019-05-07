package reqres;

import java.io.IOException;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

class MyInterceptor2 implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		return execution.execute(request, body);
	}
}
public class PutComsumer {
	public static void main(String[] args) {
		String url = "https://reqres.in/api/user/2";
		RestTemplate template = new RestTemplate();
		template.setInterceptors(Collections.singletonList(new MyInterceptor2()));
		User u = new User();
		u.setName("Syn");
		u.setJob("Comp");
		HttpEntity<User> entity = new HttpEntity<User>(u);
		ResponseEntity<String> str = template.exchange(url, HttpMethod.PUT, entity, String.class);
		System.out.println("Returned" + str);
	}
}