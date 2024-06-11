package kr.co.clover.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		
		return "redirect:/";
	}	
	
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
	
	@GetMapping("/login")
	public void login() {
		
	}	
	
	@GetMapping("/check/{userid}")
	@ResponseBody
	public Map<String, String> checkUsername(@PathVariable("userid") String userid){
		Map<String, String> map = new HashMap<String, String>();
		
		Member member = mService.findByUsername(userid);
		
		if(member == null) {
			map.put("result", "사용할 수 있는 아이디입니다.");
		}else {
			map.put("result", "사용할 수 없는 아이디입니다.");
		}
		
		
		return map;
	}
	
	@PostMapping("/delete")
	public String delete(Member member) {
		mService.delete(member);
		
		return "redirect:/board/list";
	}	
	
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
	
	@GetMapping("/update/{userid}")
	public String update(@PathVariable("userid") String userid, Model model) {
		
		Member member = mService.getMemberForUpdate(userid);
		
		model.addAttribute("member", member);
		
		return "member/update";
	}

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
	
	@GetMapping("/update/password/{userid}")
	public String updatePassword(@PathVariable("userid") String userid) {
		
		return "/member/updatePassword";
	}	
	
	@GetMapping("/detail/{userid}")
	public String detail(@PathVariable("userid") String userid, Model model) {
		Member member = mService.findByUsername(userid);
		
		model.addAttribute("member", member);
		
		return "/member/detail";
	}
	
	
	@GetMapping("/insert")
	public String insert() {
		
		return "member/insert";
	}
	
	
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
