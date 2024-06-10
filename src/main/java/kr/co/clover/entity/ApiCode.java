package kr.co.clover.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiCode {

	private Map<String, Integer> sigunguCode;
	private Map<String, List<String>> contentsCode;

	public ApiCode() {
		setSigunguCode();
		setContentsCode();
	}
	
	private void setSigunguCode() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("강남구", 1);
		map.put("강동구", 2);
		map.put("강북구", 3);
		map.put("강서구", 4);
		map.put("관악구", 5);
		map.put("광진구", 6);
		map.put("구로구", 7);
		map.put("금천구", 8);
		map.put("노원구", 9);
		map.put("도봉구", 10);
		map.put("동대문구", 11);
		map.put("동작구", 12);
		map.put("마포구", 13);
		map.put("서대문구", 14);
		map.put("서초구", 15);
		map.put("성동구", 16);
		map.put("성북구", 17);
		map.put("송파구", 18);
		map.put("양천구", 19);
		map.put("영등포구", 20);
		map.put("용산구", 21);
		map.put("은평구", 22);
		map.put("종로구", 23);
		map.put("중구", 24);
		map.put("중랑구", 25);
		
		this.sigunguCode = map;
	}
	
	private void setContentsCode() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("음식", List.of("39"));
		map.put("명소", List.of("12", "25"));
		map.put("오락", List.of("14", "28", "38"));
		
		this.contentsCode = map;
		
	}
	
	public Integer getSigunguCode(String key) {
		return sigunguCode.get(key);
	}
	
	public List<String> getContentsCode(String key){
		return contentsCode.get(key);
	}
}
