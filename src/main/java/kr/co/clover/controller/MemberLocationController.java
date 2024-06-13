package kr.co.clover.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.clover.entity.Location;
import kr.co.clover.entity.Member;
import kr.co.clover.entity.MemberLocation;
import kr.co.clover.service.LocationService;
import kr.co.clover.service.MemberLocationService;
import kr.co.clover.service.MemberService;

@Controller
@RequestMapping("likes")
public class MemberLocationController {
	@Autowired
	private MemberLocationService mlService;
	
	@Autowired
	private LocationService lService;
	
	@Autowired
	private MemberService mService;

	@GetMapping("insert/{locationId}")
	public String insertLike(HttpSession session, HttpServletRequest request, @PathVariable("locationId") String locationId) {
		
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		MemberLocation memberLocation = new MemberLocation();
		memberLocation.setLocationId(locationId);
		memberLocation.setMemberId(member.getId());
		
		mlService.insertJjim(memberLocation);
		
		return "redirect:/";
	}

	@GetMapping("list")
	public String getLikeList(Model model, HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
		
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		List<String> locationIdList = mlService.findByMemberId(member.getId());
				
		Page<Location> paging = lService.findByLocationIds(locationIdList, page-1);
				
		model.addAttribute("paging", paging);
		
		return "member_location/likes";
	}
	
	@GetMapping("countLikes")
	@ResponseBody
	public String countLikes(HttpServletRequest request) {
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		int count = mlService.countByMemberId(member.getId());
		
		return "" + count;
	}

}
