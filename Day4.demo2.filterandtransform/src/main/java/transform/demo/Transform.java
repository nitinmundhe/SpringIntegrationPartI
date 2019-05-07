package transform.demo;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class Transform{
	
	@Transformer
	public String change(String str) {
		return str.toUpperCase();
	}
	

	
}