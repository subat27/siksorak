package kr.co.clover.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ApiService {
	
	private String tour_api_key;

	public ApiService(@Value("${tour-api-key}") String test) {
		tour_api_key = test;
	}
	
	public String getTourApiKey() {
		return this.tour_api_key;
	}
	
}
