package kr.co.clover.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.clover.entity.Location;
import kr.co.clover.repository.LocationRepository;

@Service
public class TestService {
	
	@Autowired
	private LocationRepository lRepository;
	
	public String callAPI(String key) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + key); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("WIN", "UTF-8")); /* 사용기기정보(정보수집용) */
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("test", "UTF-8")); /* 서비스명(어플명) */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10000", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* response type 설정 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
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
		
		return sb.toString();
	}
	
	public void insertItems(String jsonString) {
		JSONObject jsonObject = new JSONObject(jsonString);
		JSONArray jsonArray = jsonObject.getJSONObject("response").getJSONObject("body")
				.getJSONObject("items").getJSONArray(("item"));

		ObjectMapper mapper = new ObjectMapper();
		for (Object o : jsonArray) {
			try {
				Location location = mapper.readValue(o.toString(), Location.class);
				lRepository.save(location);				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Page<Location> findAll(int page){
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount,
				Sort.by(Sort.Direction.DESC, "id"));
		
		return lRepository.findAll(pageable);
	}
	
	public List<Location> findLocationByAddress(String address){
		return lRepository.findByAddr1Containing(address);
	}
	
	public List<Location> findLocationByTitle(String title){
		return lRepository.findByTitleContaining(title);
	}

}
