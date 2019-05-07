package filter.demo;

import java.io.File;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class Filter implements MessageSelector {

	public Filter() {
		super();
		System.out.println("Filter Constructor...");
	}

	@Override
	public boolean accept(Message<?> message) {
		System.out.println("Accept Header = [...  "+ message.getHeaders()+ " ...] Payload = [ ..."+ message.getPayload()+"...]");
		if (message.getPayload() instanceof File) {
			File f1 = (File) message.getPayload();
			if (f1.getName().endsWith(".csv")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}