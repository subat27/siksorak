package kr.co.clover.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.clover.service.ApiService;
import kr.co.clover.service.WeatherService;

@Controller
@RequestMapping("weather")
public class WeatherController {
	
	@Autowired
	private WeatherService wService;
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("api")
	public void getData() {
		try {
			wService.callAPI(apiService.getTourApiKey());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
