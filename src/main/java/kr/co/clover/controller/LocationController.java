package kr.co.clover.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.clover.entity.ApiCode;
import kr.co.clover.entity.Location;
import kr.co.clover.service.ApiService;
import kr.co.clover.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private ApiService apiService;
	
	@Autowired
	private LocationService lService;
	
	// api로 서울 관광지 정보를 가져와서 DB에 저장 
	@GetMapping("insert")
	public String insert() {
		try {
			lService.insertItems(apiService.getSeoulLocationData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	// 상세 페이지로 이동
	@GetMapping("detail")
	public String detail(String contentId, Model model) {
		String contentTypeId = lService.findLocation(contentId).getContenttypeid();
		try {
			model.addAttribute("details", apiService.detailContent(contentId));
			model.addAttribute("details2", apiService.detailContent2(contentId, contentTypeId));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "location/detail";
	}

	// 관광지 목록을 출력하는 코드
	@GetMapping("list")
	@Transactional
	public String listLocation(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model,
			String keyword, String contentType, String sigunguCode, HttpSession session) {
		page -= 1;
		
		Page<Location> paging = null;
		ApiCode apiCode = new ApiCode();
		
		if (contentType == "") {
			paging = lService.findLocationExceptTheme(page, keyword, sigunguCode);
		} else {
			paging = lService.findLocationContainTheme(page, keyword, sigunguCode, apiCode.getContentsCode(contentType));
		}
		
		for (Location location : paging.getContent()) {
			location.getMembers().size();
		}
		
		model.addAttribute("paging", paging);
		session.setAttribute("keyword", keyword);
		session.setAttribute("sigunguCode", sigunguCode);
		session.setAttribute("contentType", contentType);
		
		return "location/list";
	}
	
	@GetMapping("test")
	public String test() {
		Location location = lService.findLocation("1059638");
		
		System.out.println(location.getMembers());
		return "mapTest";
	}
	
	// 지도 API 호출 테스트용
	@GetMapping("map")
	public String map() {
		return "mapTest";
	}

}
