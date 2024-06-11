package kr.co.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.clover.entity.Member;
import kr.co.clover.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository mRepository;
	
	public boolean findByUseridAndPassword(Member member) {
		
		Member login = mRepository.findByUseridAndPassword(member.getUserid(), member.getPassword());
		if(login == null) {
			return false;
		}
		
		return true;
	}	
	
	
	public void delete(Member member) {

		Member dbMember = mRepository.findByUseridAndPassword(
							member.getUserid(), 
							member.getPassword());
		
		if(dbMember == null) {
			throw new RuntimeException("해당 회원은 없음");
		}
		
		mRepository.delete(dbMember);
		
	}
	
	
	public void saveForUpdate(Member member) {
		Member dbMember = mRepository.findByUseridAndPassword(
													member.getUserid(), 
													member.getPassword());
		
		if(dbMember == null) {
			return;
		}
		
		member.setCreateDate(dbMember.getCreateDate());
		member.setId(dbMember.getId());
		mRepository.save(member);	
	}	
	
	
	public Member getMemberForUpdate(String userid) {

		return mRepository.findByUserid(userid);
		}
	
	
	public void save(Member member, String userid, 
			String org_password) {

			Member dbMember = mRepository.findByUseridAndPassword(
									userid, 
									org_password);

			if(dbMember == null) {
				return;
			}

			dbMember.setPassword(member.getPassword());
			dbMember.setUpdateDate(member.getUpdateDate());

			mRepository.save(dbMember);

	}	
	
	
	public Member findByUsername(String userid) {
		Member member = mRepository.findByUserid(userid);
		
		return member;
	}
	
	public void save(Member member) {
		
		mRepository.save(member);
	}
	
}
