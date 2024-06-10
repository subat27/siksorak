package kr.co.clover.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.clover.entity.Location;
import kr.co.clover.service.ApiService;
import kr.co.clover.service.TestService;

@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	private TestService tService;
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("location")
	public String location() {
		return "location/list";
	}
	
	@GetMapping("test")
	public String test() {
		
	try {
		tService.insertItems(tService.callAPI(apiService.getTourApiKey()));
	} catch (Exception e) {
		e.printStackTrace();
	};
		
		return "index";
	}
	
	@GetMapping("test2")
	public String test2(String contentId, Model model) {
		try {
			model.addAttribute("details", tService.detailContent(contentId, apiService.getTourApiKey()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "location/detail";
	}
	
	@GetMapping("list")
	public String listLocation(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
		page -= 1;
		Page<Location> paging = tService.findAll(page); 
		model.addAttribute("paging", paging);
		return "location/list";
	}
	
	@GetMapping("map")
	public String map() {
		return "mapTest";
	}

}
