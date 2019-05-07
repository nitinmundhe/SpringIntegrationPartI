package reqres;

import java.io.IOException;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

class MyInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		return execution.execute(request, body);
	}

}

public class GetConsumer {

	public static void firstControllerClient() {
		String url = "https://reqres.in/api/user/2";
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("", headers);

		ResponseEntity<String> resentity = template.exchange(url, HttpMethod.GET, entity, String.class);
		if (resentity.getStatusCodeValue() == 200) {
			System.out.println(resentity.getHeaders());
			System.out.println(resentity.getBody());
		}
	}

	public static void secondControllerClient() {
		String url = "https://reqres.in/api/user/2";
		RestTemplate template = new RestTemplate();
		template.setInterceptors(Collections.singletonList(new MyInterceptor()));

		ResponseEntity<String> resentity = template.getForEntity(url, String.class);
		if (resentity.getStatusCodeValue() == 200) {
			System.out.println(resentity.getHeaders());
			System.out.println(resentity.getBody());
		}
	}

	public static void main(String[] args) {
		// SpringApplication.run(RESTSimpleApplication.class, args);
		firstControllerClient();

	}
}