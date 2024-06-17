package kr.co.clover.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.clover.entity.WeatherInfo;



@Service
public class WeatherService {
	// 단기예보 결과
	public Map<String, WeatherInfo> getVilageFcst(String apiKey, String date) throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst");
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + apiKey);
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode("0500", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode("60", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode("127", "UTF-8"));

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		System.out.println(sb.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObject = new JSONObject(sb.toString()); 
		String jsonString = jsonObject.getJSONObject("response").getJSONObject("body")
		.getJSONObject("items").getJSONArray(("item")).toString();
			
		List<Map<String, Object>> rawData = mapper.readValue(jsonString, new TypeReference<List<Map<String, Object>>>() {});
	    Map<String, WeatherInfo> organizedData = new TreeMap<>();
		
		for(Map<String, Object> entry : rawData) {
			String fcstDate = (String) entry.get("fcstDate");
			String fcstTime = (String) entry.get("fcstTime");
			String category = (String) entry.get("category");
			String fcstValue = String.valueOf(entry.get("fcstValue"));
			
			String key = fcstDate + fcstTime;
			organizedData.putIfAbsent(key, new WeatherInfo());
			WeatherInfo weatherInfo = organizedData.get(key);
			
			weatherInfo.setFcstDate(fcstDate);
			weatherInfo.setFcstTime(fcstTime);
			if (weatherInfo.getCategories() == null) {
				weatherInfo.setCategories(new TreeMap<>());
			}
			weatherInfo.getCategories().put(category, fcstValue);
		}
		
		return organizedData;
	}
	
}
