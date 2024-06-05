package kr.co.clover.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	

	@Value("${tour_api_key}")
	private String tour_api_key;
	

	public String callAPI() throws IOException {

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B551011/KorService1/searchKeyword1"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + tour_api_key); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("WIN", "UTF-8")); /* 사용기기정보(정보수집용) */
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("test", "UTF-8")); /* 서비스명(어플명) */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("keyword", "UTF-8") + "=" + URLEncoder.encode("서울", "UTF-8")); /* 검색 키워드 */
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
	
	public void printItems(String jsonString) {

		JSONObject jsonObject = new JSONObject(jsonString);
		JSONArray jsonArray = jsonObject.getJSONObject("response").getJSONObject("body")
				.getJSONObject("items").getJSONArray(("item"));
		
//		for (int i=0; i<jsonArray.length(); i++) {
//			JSONObject obj = jsonArray.getJSONObject(i);
//			String addr1 = obj.getString("addr1");
//			String addr2 = obj.getString("addr2");
//			String firstimage2 = obj.getString("firstimage2");
//			String title = obj.getString("title");
//			Double mapx = obj.getDouble("mapx");
//			Double mapy = obj.getDouble("mapy");
//			String tel = obj.getString("tel");
//			System.out.println("주소 : " + addr1 + " / " + addr2  + "\n사진경로 : " + firstimage2  + "\n제목 : " + title  + "\n좌표 : " + mapx + " / " + mapy  + "\n전화번호 : " + tel);
//		}
		
		System.out.println(jsonArray.length());
	}

}
