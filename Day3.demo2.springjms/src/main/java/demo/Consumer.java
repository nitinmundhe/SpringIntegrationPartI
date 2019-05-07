package demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@JmsListener(destination = "MyTopic", containerFactory = "myFactory")
	public void receiver1(String s) {
		System.out.println("In MyConsumer1 Receiver.." + s);
	}

	@JmsListener(destination = "MyQueue", containerFactory = "myFactory")
	public void receiver2(String s) {
		System.out.println("In MyConsumer2 Receiver.." + s);
	}	
	

    @JmsListener(destination = "MyUser", containerFactory = "myFactory")
    public void receiveMessage(User user) {
        System.out.println("Received <" + user + ">");
    }
    
    @JmsListener(destination = "AQueue", containerFactory = "myFactory")
    public void receiveString(String str) {
        System.out.println("Received <" + str + ">");
    }
}