package kr.co.clover.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.UtilsForBoard;
import kr.co.clover.entity.Member;
import kr.co.clover.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService mService;

	@GetMapping("/jjim/{test}")
	@ResponseBody
	public int jjim(@PathVariable("test") Integer test, HttpSession session, HttpServletRequest request){
		return test;
	}	
	
	// 로그인 기능 수행
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		boolean result = mService.findByUseridAndPassword(member);
		
		if(result) {
			member.setPassword(null);
			session.setAttribute("login", member);
			return "redirect:/";
		}else {
			return "/member/login";
		}
	}	

	// 로그인 화면으로 이동
	@GetMapping("/login")
	public void login() {
	}	
	
	// 로그아웃 기능 수행
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}	
	
	// 회원가입 아이디 유효성 검사
	@GetMapping("/check/{userid}")
	@ResponseBody
	public Map<String, String> checkUserid(@PathVariable("userid") String userid){
		Map<String, String> map = new HashMap<String, String>();
		
		Member member = mService.findByUserid(userid);
		
		if(member == null) {
			map.put("result", "사용할 수 있는 아이디입니다.");
		}else {
			map.put("result", "사용할 수 없는 아이디입니다.");
		}
		
		return map;
	}
	
	// 회원 탈퇴
	@PostMapping("/delete")
	public String delete(Member member) {
		mService.delete(member);
		
		return "redirect:/board/list";
	}	

	// 회원 정보 수정
	@PostMapping("/update/{userid}")
	public String update(Member member) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String now = sdf.format(d);
		
		member.setUpdateDate(now);
		
		//DB 작업
		mService.saveForUpdate(member);
		
		return "redirect:/member/detail/"+member.getUserid();
	}	
	
	// 회원 정보 수정 화면으로 이동
	@GetMapping("/update/{userid}")
	public String update(@PathVariable("userid") String userid, Model model) {
		
		Member member = mService.getMemberForUpdate(userid);
		
		model.addAttribute("member", member);
		
		return "member/update";
	}

	// 비밀번호 수정
	@PostMapping("/update/password/{userid}")
	public String updatePassword(@PathVariable("userid") String userid,
														String org_password, 
														Member member) {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String now = sdf.format(d);
		
		member.setUpdateDate(now);
		
		mService.save(member, userid, org_password);

		
		return "redirect:/member/detail/"+userid;
	}
		
	// 비밀번호 수정 화면으로 이동
	@GetMapping("/update/password/{userid}")
	public String updatePassword(@PathVariable("userid") String userid) {
		
		return "/member/updatePassword";
	}	
	
	// 마이페이지로 이동
	@GetMapping("/detail/{userid}")
	public String detail(@PathVariable("userid") String userid, Model model) {
		Member member = mService.findByUserid(userid);
		
		model.addAttribute("member", member);
		
		return "/member/detail";
	}
	
	// 회원 가입 화면으로 이동
	@GetMapping("/insert")
	public String insert() {
		
		return "member/insert";
	}
	
	// 회원 가입 기능 수행
	@PostMapping("/insert")
	public String insert(Member member, Model model) {
		
		boolean result = UtilsForBoard.validateMember(member);
		
		if(!result) {			
			model.addAttribute("member", member);
			return "/member/insert";
		}
				
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String now = sdf.format(d);
		
		member.setCreateDate(now);
		member.setUpdateDate(now);
		
		mService.save(member);
		
		return "redirect:/";
	}
	
}
