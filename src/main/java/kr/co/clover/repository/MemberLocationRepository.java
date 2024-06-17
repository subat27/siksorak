package kr.co.clover.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.MemberLocation;
import kr.co.clover.entity.MemberLocationId;

@Repository
public interface MemberLocationRepository extends JpaRepository<MemberLocation, MemberLocationId> {

	Page<MemberLocation> findLocationById_MemberId(Integer memberId, Pageable pageable);
	
	Optional<MemberLocation> findById_MemberIdAndId_contentid(Integer memberId, String contentid);
	
	int countById_MemberId(Integer memberId);
	
	int countById_Contentid(String locationId);
	
	List<MemberLocation> findById_Contentid(String contentid);

}
