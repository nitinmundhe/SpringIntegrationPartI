package repres.consumers;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpRequest;

public class GetClient {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClients.createDefault();
		//HttpHost httpHost = new HttpHost("https://reqres.in/api/users");
		HttpHost httpHost = new HttpHost("reqres.in");
		HttpRequest httpRequest = new BasicHttpRequest("GET","/api/users");
		
		//HttpResponse response = httpClient.execute(httpHost,httpRequest);
		//System.out.println(response.toString()); // Lazy loading only called when requested
		
		ResponseHandler<String> rhandler = new BasicResponseHandler();
		String str = httpClient.execute(httpHost,httpRequest,rhandler);
		System.out.println(str.toString()); 		
	}		
}