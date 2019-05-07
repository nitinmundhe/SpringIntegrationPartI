package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class InboundEndpoint {

	public Message<?> get(Message<?> message) {
		
		List<Flights> flights = new ArrayList<Flights>();
		flights.add(new Flights("PNQ", "DEL", "ABC","1"));
		flights.add(new Flights("PNQ", "DEL", "ABC","2"));		
		return MessageBuilder.withPayload(flights).copyHeaders(message.getHeaders()).setHeader("http_statusCode", HttpStatus.OK).build();

	}

}
