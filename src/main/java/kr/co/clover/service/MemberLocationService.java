package kr.co.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Page<MemberLocation> findByMemberId(Integer memberId, int page) {
		int pagePerBoardCount = 3;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "id"));
		return mlRepository.findLocationById_MemberId(memberId, pageable);
	}

	// 회원별 찜 목록 개수 출력, 네비게이션 찜목록 숫자표시에 사용
	public int countByMemberId(Integer memberid) {
		return mlRepository.countById_MemberId(memberid);
	}

	// 찜 목록에서 삭제
	public String deleteJjim(Integer memberId, String contentid) {
		MemberLocation ml = mlRepository.findById_MemberIdAndId_contentid(memberId, contentid).get();
		mlRepository.deleteById(ml.getId());
		
		return "delete";
	}
	
	// 관광지별 찜 목록 개수 출력
	public int countByLocationId(String locationId) {
		return mlRepository.countById_Contentid(locationId);
	}
	
	
}
