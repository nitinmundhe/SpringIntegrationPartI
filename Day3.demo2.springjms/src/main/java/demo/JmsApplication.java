package demo;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class JmsApplication {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configure) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configure.configure(factory, connectionFactory);
		//factory.setPubSubDomain(true);
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JmsApplication.class, args);
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		//jmsTemplate.setPubSubDomain(true);
		
		 for (int i = 0; i < 2; i++) { jmsTemplate.convertAndSend("MyTopic", "Hello "
		 + i); }
		 
		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an User object.");
		/*for (int i = 0; i < 15; i++) {
			User user = new User();
			user.setFirstname("abc"+i);
			user.setLastname("pqr"+i);
			user.setUserid("1"+i);
			jmsTemplate.convertAndSend("MyUser", user);
		}*/
		
	}

}
