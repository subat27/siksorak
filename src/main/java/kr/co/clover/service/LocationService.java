package kr.co.clover.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
public class LocationService {

	@Autowired
	private LocationRepository lRepository;
	
	// api로 호출한 관광지 정보를 DB에 등록
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
	
	// 전체 관광지 목록을 호출
	public Page<Location> findAll(int page) {
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "title"));		
		return lRepository.findAll(pageable);
	}
	
	// 특정 관광지를 호출
	public Location findLocation(String contentId) {
		return lRepository.findById(contentId).get();
	}
	
	// 관광지 목록에서 테마를 선택하지 않았을 때 목록
	public Page<Location> findLocationExceptTheme(int page, String keyword, String sigungucode){
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount,
				Sort.by(Sort.Direction.ASC, "id"));		
		
		return lRepository.findByTitleOrAddr1AndSigungucode(keyword, keyword, sigungucode, pageable);		
	}

	// 관광지 목록에서 테마를 선택했을 때 목록 - 테마를 포함하는 부분의 SQL문이 달라서 별도로 구현
	public Page<Location> findLocationContainTheme(int page, String keyword, String sigungucode, List<String> contentTypeId){
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount,
				Sort.by(Sort.Direction.ASC, "id"));
				
		return lRepository.findByTitleOrAddr1AndSigungucodeAndContentTypeId(keyword, keyword, sigungucode, contentTypeId, pageable);
	}

	// 찜 목록 가져오기 위해서 별도로 구현한 메소드
	public Page<Location> findByLocationIds(List<Location> locationIdList, int page) {
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "id"));
		return lRepository.findByContentidIn(locationIdList, pageable);
	}
	
}
