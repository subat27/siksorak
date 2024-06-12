package kr.co.clover.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.UtilsForBoard;
import kr.co.clover.entity.ApiCode;
import kr.co.clover.entity.Location;
import kr.co.clover.entity.Member;
import kr.co.clover.service.ApiService;
import kr.co.clover.service.TestService;

@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	private TestService tService;

	@Autowired
	private ApiService apiService;
	


	@GetMapping("jjim")
	public String jjimLocation(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model,
			String keyword, String contentType, String sigunguCode, HttpSession session) {
		page -= 1;
		
		Page<Location> paging = null;
		
		if (keyword != null) {
			paging = tService.findByKeyword(page, keyword);
		} else if (contentType != null) {
			ApiCode apiCode = new ApiCode();
			System.out.println(apiCode.getContentsCode(contentType));
			paging = tService.findByContentType(page, apiCode.getContentsCode(contentType));
			session.setAttribute("contentType", contentType);
		} else if (sigunguCode != null) {
			ApiCode apiCode = new ApiCode();
			System.out.println(apiCode.getSigunguCode(sigunguCode));
			paging = tService.findBySigungucode(page, apiCode.getSigunguCode(sigunguCode));
			session.setAttribute("sigunguCode", sigunguCode);
		} else {
			paging = tService.findAll(page);
		}
		
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		return "member_location/jjim";
	}

	@GetMapping("location")
	public String location() {
		return "location/list";
	}

	@GetMapping("test")
	public String test() {

		try {
			tService.insertItems(tService.callAPI(apiService.getTourApiKey()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

		return "index";
	}

	@GetMapping("test2")
	public String test2(String contentId, Model model) {
		try {
			model.addAttribute("details", tService.detailContent(contentId, apiService.getTourApiKey()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "location/detail";
	}

	@GetMapping("list")
	public String listLocation(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model,
			String keyword, String contentType, String sigunguCode, HttpSession session) {
		page -= 1;
		
		Page<Location> paging = null;
		
		if (keyword != null) {
			paging = tService.findByKeyword(page, keyword);
		} else if (contentType != null) {
			ApiCode apiCode = new ApiCode();
			System.out.println(apiCode.getContentsCode(contentType));
			paging = tService.findByContentType(page, apiCode.getContentsCode(contentType));
			session.setAttribute("contentType", contentType);
		} else if (sigunguCode != null) {
			ApiCode apiCode = new ApiCode();
			System.out.println(apiCode.getSigunguCode(sigunguCode));
			paging = tService.findBySigungucode(page, apiCode.getSigunguCode(sigunguCode));
			session.setAttribute("sigunguCode", sigunguCode);
		} else {
			paging = tService.findAll(page);
		}
		
		model.addAttribute("paging", paging);
		model.addAttribute("keyword", keyword);
		return "location/list";
	}

	@GetMapping("map")
	public String map() {
		return "mapTest";
	}

}
