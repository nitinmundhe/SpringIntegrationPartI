package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value="second")
@RestController
@RequestMapping(value="/second")
public class SecondController {
	//@RequestMapping(method=RequestMethod.GET)
	//@GetMapping
	@GetMapping(value="/m1")
	public String m1() {
		String str = "GET In M1 - Second Controller";
		System.out.println(str);
		return str;
	}
	@GetMapping(value="/m2")
	public String m2() {
		String str = "GET In M1 - Third Controller";
		System.out.println(str);
		return str;
	}
}