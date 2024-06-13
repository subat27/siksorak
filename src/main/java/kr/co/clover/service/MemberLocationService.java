package kr.co.clover.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.clover.entity.MemberLocation;
import kr.co.clover.repository.MemberLocationRepository;

@Service
public class MemberLocationService {
	@Autowired
	private MemberLocationRepository mlRepository;
	
	// 찜 목록 추가
	public void insertJjim(MemberLocation memberLocation) {
		mlRepository.save(memberLocation);
	}
	
	// 회원별 찜 목록 (관광지 contentId 의 리스트 반환)
	public List<String> findByMemberId(Integer memberId) {
		return mlRepository.findLocationIdByMemberId(memberId);
	}

	// 회원별 찜 목록 개수 출력
	public int countByMemberId(Integer memberid) {
		return mlRepository.countByMemberId(memberid);
	}
	
	// 관광지별 찜 목록 개수 출력 (추가예정)
}
