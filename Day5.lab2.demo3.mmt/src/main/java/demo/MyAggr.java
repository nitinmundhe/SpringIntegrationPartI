package demo;

import org.springframework.stereotype.Component;

@Component
public class MyAggr {

	  @Aggregator
	  public Delivery aggregatingMethod(List<OrderItem> items) {
	    ...
	  }

	  @ReleaseStrategy
	  public boolean releaseChecker(List<Message<?>> messages) {
	    ...
	  }

	  @CorrelationStrategy
	  public String correlateBy(OrderItem item) {
	    ...
	  }
	
}
