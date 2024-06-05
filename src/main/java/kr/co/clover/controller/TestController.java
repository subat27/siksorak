package kr.co.clover.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.clover.service.TestService;

@Controller
@RequestMapping("/")
public class TestController {

	private TestService service = new TestService();
	
	@GetMapping("location")
	public String location() {		
		return "location/list";
	}
	
	@GetMapping("test")
	public String test() {
		
		try {
			service.printItems(service.callAPI());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		};
		
		return "index";
	}

}
