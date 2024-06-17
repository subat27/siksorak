package kr.co.clover.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.clover.entity.Location;
import kr.co.clover.entity.Member;
import kr.co.clover.entity.MemberLocation;
import kr.co.clover.entity.MemberLocationId;
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

	// 찜 목록 등록 
	@GetMapping("insert/{contentId}")
	@ResponseBody
	public String insertLike(HttpSession session, HttpServletRequest request, @PathVariable("contentId") String contentId) {
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		Location location = lService.findLocation(contentId);
				
		MemberLocation memberLocation = new MemberLocation();
		MemberLocationId memberLocationId = new MemberLocationId(member.getMemberId(), contentId);
		memberLocation.setId(memberLocationId);
		memberLocation.setLocation(location);
		
		memberLocation.setMember(member);
		
		mlService.insertJjim(memberLocation);
		location.setCount(location.getCount()+1);
		lService.modify(location);
		
		return "{\"result\" : \"success\"}";
	}

	// 찜 목록에서 제거 
	@GetMapping("delete/{locationId}")
	public String deleteLike(HttpSession session, HttpServletRequest request, @PathVariable("locationId") String locationId) {
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		Location location = lService.findLocation(locationId);
		
		mlService.deleteJjim(member.getMemberId(), locationId);
				
		location.setCount(location.getCount()-1);
		lService.modify(location);
		
		return "redirect:/likes/list";
	}
	
	// 찜 목록 출력
	@GetMapping("list")
	@Transactional(readOnly = true)
	public String getLikeList(Model model, HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
		
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		Page<MemberLocation> paging = mlService.findByMemberId(member.getMemberId(), page-1);
				
		for( MemberLocation ml : paging.getContent()) {
			System.out.println(ml.getLocation().getFirstimage());
			System.out.println(ml.getMember().getAge());
			ml.getLocation().setCount();
		}
		
		model.addAttribute("paging", paging);
		
		return "member_location/likes";
	}

	// 찜 해놓은 장소 개수 출력
	@GetMapping("countLikes")
	@ResponseBody
	@Transactional(readOnly = true)
	public String countLikes(HttpServletRequest request) {
		Member member = (Member) request.getSession(false).getAttribute("login");
		member = mService.findByUserid(member.getUserid());
		
		int count = mlService.countByMemberId(member.getMemberId());
		
		return "{\"result\" : \"" + count + "\"}";
	}

	// 관광지를 찜 해놓은 유저의 수를 출력
	@GetMapping("countMembers/{locationId}")
	@ResponseBody
	public String countUsers(HttpServletRequest request, @PathVariable("locationId") String locationId) {
		int count = mlService.countByLocationId(locationId);
		return "{\"result\" : \"" + count + "\"}";
	}
	
}
