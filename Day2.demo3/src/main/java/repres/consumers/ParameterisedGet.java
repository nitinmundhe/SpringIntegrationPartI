package repres.consumers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

public class ParameterisedGet {

	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		String url = "https://reqres.in/api/users/";
		HttpClient client = HttpClients.createDefault();
		URIBuilder builder = new URIBuilder(url);
		builder.setParameter("page", "4");		
		
		HttpGet get = new HttpGet(builder.build());
		HttpResponse response = client.execute(get);
		System.out.println(response.getEntity().getContent().toString());
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}		
	}
}
