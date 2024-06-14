package kr.co.clover.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {
	private String fcstDate;
	private String fcstTime;
	private Map<String, String> categories;
}
