package repres.consumers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class PostClient {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost(new URI("https://reqres.in/api/users"));
		StringEntity params = new StringEntity("{\"name\":\"morpheus\",\"job\":\"leader\"} ");
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}