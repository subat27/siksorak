package kr.co.clover.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.clover.entity.EventInfo;
import kr.co.clover.service.ApiService;
import kr.co.clover.service.EventInfoService;

@Controller
@RequestMapping("event")
public class EventInfoController {
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private EventInfoService eventInfoService;
	
	@GetMapping("insert")
	public String test() {
		try {
			eventInfoService.insertEventItem(apiService.getEventInfoData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	// 진행중인 축제 목록을 출력하는 코드
	@GetMapping("list")
	public String list(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model,
			String sigunguCode, HttpSession session) {
		
		page -= 1;
		
		Page<EventInfo> paging = eventInfoService.findAllEventList(page);
		
		model.addAttribute("paging", paging);
		
		return "location/eventList";
	}
	
	
}
