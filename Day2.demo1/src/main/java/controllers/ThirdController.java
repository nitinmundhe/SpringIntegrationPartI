package controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/third")
public class ThirdController {

	@GetMapping(produces=MediaType.TEXT_PLAIN_VALUE)
	public String m1() {
		String str = "GET In M1 - Third Controller";
		System.out.println(str);
		return str;
	}
	
	@GetMapping(produces=MediaType.TEXT_HTML_VALUE)
	public String m2() {
		String str = "<html><b>POST In M1 - Third Controller</b></html>";
		System.out.println(str);
		return str;
	}
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public String m3() {
		String str ="{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}";
		System.out.println(str);
		return str;
	}
	@GetMapping(produces=MediaType.APPLICATION_XML_VALUE)
	public String m4() {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
                "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"+
                "<role>Developer</role><gen>Male</gen></Emp>";
		System.out.println(str);
		return str;
	}

}
