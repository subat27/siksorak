package kr.co.clover.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.clover.service.ApiService;
import kr.co.clover.service.WeatherService;

@Controller
@RequestMapping("weather")
public class WeatherController {
	
	@Autowired
	private WeatherService wService;
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("nowData")
	@ResponseBody
	public Map<String, String> getData() {
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//		int hour = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HH"))) + 1;
//		int page = hour 
//		hour = (Integer.parseInt(hour) + 1) + "00";
		String hour = "1400";
		try {
			Map<String, String> categories = wService.getVilageFcst(apiService.getTourApiKey(), date).get(date+hour).getCategories();
			
			return categories;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
