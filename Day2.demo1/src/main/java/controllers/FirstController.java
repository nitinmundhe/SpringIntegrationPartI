package controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value="first")
//@Controller
@RestController
@RequestMapping(value="/first")
public class FirstController {
	//@RequestMapping(method=RequestMethod.GET)
	//@GetMapping
	@GetMapping
	public String m1() {
		String str = "GET In M1 - First Controller";
		System.out.println(str);
		return str;
	}
	
	@PostMapping
	public String m2() {
		String str = "POST In M1 - First Controller";
		System.out.println(str);
		return str;
	}
	
	@PutMapping
	public String m3() {
		String str = "PUT In M1 - First Controller";
		System.out.println(str);
		return str;
	}
	
	@DeleteMapping
	public String m4() {
		String str = "DELETE In M1 - First Controller";
		System.out.println(str);
		return str;
	}
	
	//Head already given by spring no need to implement
	//Even Option is implemented by Spring
	
	
}
