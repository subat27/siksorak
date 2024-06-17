package kr.co.clover.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.clover.entity.EventInfo;
import kr.co.clover.repository.EventInfoRepository;

@Service
public class EventInfoService {

	@Autowired
	private EventInfoRepository eventInfoRepository;

	public void insertEventItem(String eventInfoData) {
		JSONObject jsonObject = new JSONObject(eventInfoData);
		JSONArray jsonArray = jsonObject.getJSONObject("response").getJSONObject("body")
				.getJSONObject("items").getJSONArray(("item"));
		
		ObjectMapper mapper = new ObjectMapper();
		for (Object o : jsonArray) {
			try {
				EventInfo eventInfo = mapper.readValue(o.toString(), EventInfo.class);
				eventInfoRepository.save(eventInfo);				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Page<EventInfo> findAllEventList(int page) {
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "title"));
		return eventInfoRepository.findAll(pageable);
	}
}
