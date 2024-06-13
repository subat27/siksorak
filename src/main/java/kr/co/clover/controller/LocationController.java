package kr.co.clover.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.clover.entity.Location;
import kr.co.clover.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationService lService;
	
	@GetMapping("list")
	public String list(@RequestParam(value="page", defaultValue = "1") Integer page, Model model,
			String keyword, String contentType, String sigunguCode, HttpSession session) {
		page -= 1;
		
		Page<Location> paging = null;
		
		if (keyword != null) {
			
		}
			
		
		return "location/list";
	}
}
