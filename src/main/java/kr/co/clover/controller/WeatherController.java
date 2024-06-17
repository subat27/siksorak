package kr.co.clover.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.clover.entity.WeatherInfo;
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
		int hour = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HH"))) + 1;
		
		// 시간대가 12시로 넘어갈 때 날짜/시간이 바뀌는 경우 처리 
		// 추후 별도의 함수로 구현 예정
		String time = hour + "00";;
		String searchDate = date; 
		if (hour == 24) {
			searchDate = date.substring(0, 7) + (Integer.parseInt(date.substring(7)) + 1);
			time = "0000";
		}
		
		if (time.length() == 3) {
			time = "0" + time;
		}
		
		if (hour < 5) {
			date =  date.substring(0, 7) + ((date.charAt(7) - '0') - 1);
			
		}
		System.out.println(searchDate+time);
		
		try {
			Map<String, String> categories = wService.getVilageFcst(apiService.getTourApiKey(), date).get(searchDate+time).getCategories();
			
			return categories;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("allData")
	public String getAllData(Model model) {
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		int hour = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HH"))) + 1;
		if (hour < 6) {
			date =  date.substring(0, 7) + ((date.charAt(7) - '0') - 1);
		}
		try {
			Map<String, WeatherInfo> categories = wService.getVilageFcst(apiService.getTourApiKey(), date);
			
			Arrays.sort(categories.keySet().toArray()); 
			
			model.addAttribute("categories", categories);
			model.addAttribute("today", date);
			
			return "weather/weatherList";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
