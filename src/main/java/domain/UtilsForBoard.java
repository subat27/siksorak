package domain;

import kr.co.clover.entity.Member;

public class UtilsForBoard {

	public static boolean validateMember(Member member) {
		
		boolean result = true;
		
		String userid = member.getUserid();
		if(userid.equals("") || userid == null) {
			result = false;
		}
		
		String password = member.getPassword();
		if(password.equals("") || password == null) {
			result = false;
		}
		
		String password2 = member.getPassword2();
		if(password2.equals("") || password2 == null) {
			result = false;
		}
		
		if(!password.equals(password2)) {
			result = false;
		}
		
		String name = member.getName();
		if(name.equals("") || name == null) {
			result = false;
		}
		
		String age = member.getAge();
		if(age.equals("") || age == null) {
			result = false;
		}
		
		
		String nation = member.getNation();
		if(nation.equals("") || nation == null) {
			result = false;
		}
		
		
		String religion = member.getReligion();
		if(religion.equals("") || religion == null) {
			result = false;
		}
		
	
				
		return result;
	}	
	
}
