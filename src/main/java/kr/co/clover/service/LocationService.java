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
	
	public Page<Location> findAll(int page) {
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "title"));		
		return lRepository.findAll(pageable);
	}
	
	public Location findLocation(int locationId) {
		return lRepository.findById(locationId).get();
	}
	
	public Page<Location> findLocationExceptTheme(int page, String keyword, String sigungucode){
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount,
				Sort.by(Sort.Direction.ASC, "id"));		
		
		return lRepository.findByTitleOrAddr1AndSigungucode(keyword, keyword, sigungucode, pageable);		
	}
	
	public Page<Location> findLocationContainTheme(int page, String keyword, String sigungucode, List<String> contentTypeId){
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount,
				Sort.by(Sort.Direction.ASC, "id"));
				
		return lRepository.findByTitleOrAddr1AndSigungucodeAndContentTypeId(keyword, keyword, sigungucode, contentTypeId, pageable);
	}

	public Page<Location> findByLocationIds(List<String> locationIdList, int page) {
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "id"));
		return lRepository.findByContentidIn(locationIdList, pageable);
	}
	
}
