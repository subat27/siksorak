package kr.co.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.clover.entity.Member;
import kr.co.clover.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository mRepository;

	// 로그인 시 아이디/비밀번호 확인용 메소드
	public boolean findByUseridAndPassword(Member member) {
		Member login = mRepository.findByUseridAndPassword(member.getUserid(), member.getPassword());
		if (login == null) {
			return false;
		}
		return true;
	}

	// 회원 탈퇴 
	public void delete(Member member) {
		Member dbMember = mRepository.findByUseridAndPassword(member.getUserid(), member.getPassword());
		if (dbMember == null) {
			throw new RuntimeException("해당 회원은 없음");
		}
		mRepository.delete(dbMember);
	}

	// 회원 정보 수정
	public void saveForUpdate(Member member) {
		Member dbMember = mRepository.findByUseridAndPassword(member.getUserid(), member.getPassword());
		if (dbMember == null) {
			return;
		}
		member.setCreateDate(dbMember.getCreateDate());
		member.setId(dbMember.getId());
		mRepository.save(member);
	}

	// 정보를 수정할 회원을 DB에서 가져옴
	public Member getMemberForUpdate(String userid) {
		return mRepository.findByUserid(userid);
	}

	// 비밀번호 수정
	public void save(Member member, String userid, String org_password) {
		Member dbMember = mRepository.findByUseridAndPassword(userid, org_password);
		if (dbMember == null) {
			return;
		}
		dbMember.setPassword(member.getPassword());
		dbMember.setUpdateDate(member.getUpdateDate());
		mRepository.save(dbMember);
	}

	// 마이페이지 조회 시 사용
	public Member findByUserid(String userid) {
		Member member = mRepository.findByUserid(userid);
		return member;
	}

	// 회원 가입
	public void save(Member member) {
		mRepository.save(member);
	}

	// 삭제할 때 사용? 언제 쓰는 함수?
	public void findById(Integer id) {
		mRepository.findById(id);
	}

}
