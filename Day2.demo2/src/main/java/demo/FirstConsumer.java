package demo;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class FirstConsumer {

	public static void firstControllerClient() {
		String url = "http://localhost:8081/first";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> resentity = template.getForEntity(url, String.class);
		if (resentity.getStatusCodeValue() == 200) {
			System.out.println(resentity.getHeaders());
			System.out.println(resentity.getBody());
		}

		System.out.println("Get Returned " + template.getForEntity(url, String.class).getBody());
		System.out.println("POST Returned " + template.postForEntity(url, null, String.class).getBody());
		template.put(url, null);
		template.delete(url);
	}

	public static void secondControllerClient() {
		String url = "http://localhost:8081/second";
		RestTemplate template = new RestTemplate();
		System.out.println("/m1 Get Returned " + template.getForEntity(url + "/m1", String.class).getBody());
		System.out.println("/m2 POST Returned " + template.postForEntity(url + "/m1", null, String.class).getBody());
		template.put(url, null);
		template.delete(url);
	}

	public static void thirdControllerClient() {
		String url = "http://localhost:8081/third";
		RestTemplate template = new RestTemplate();
		System.out.println("Get Returned default " + template.getForEntity(url, String.class).getBody());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);//parameters is dummy name used as only key value pair is required here
		System.out.println("Get Returned default " + template.exchange(url, HttpMethod.GET, entity, String.class));
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<String>("parameters",headers);//parameters is dummy name used as only key value pair is required here
		System.out.println("Get Returned default " + template.exchange(url, HttpMethod.GET, entity, String.class));
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		entity = new HttpEntity<String>("parameters",headers);//parameters is dummy name used as only key value pair is required here
		System.out.println("Get Returned default " + template.exchange(url, HttpMethod.GET, entity, String.class));
		
	}

	public static void main(String[] args) {
		// SpringApplication.run(RESTSimpleApplication.class, args);
		// firstControllerClient();
		// secondControllerClient();
		thirdControllerClient();
	}
}