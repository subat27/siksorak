package kr.co.clover.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.clover.entity.Location;
import kr.co.clover.entity.MemberLocation;
import kr.co.clover.entity.MemberLocationId;

@Repository
public interface MemberLocationRepository extends JpaRepository<MemberLocation, MemberLocationId> {

	/*
	 * @Query("SELECT ml FROM MemberLocation ml where ml.id.memberId = :memberId")
	 * List<Location> findLocationByMemberId(@Param("memberId") Integer memberId);
	 */
	
	Page<MemberLocation> findLocationById_MemberId(Integer memberId, Pageable pageable);
	
	int countById_MemberId(Integer memberId);
	
	int countById_Contentid(String locationId);

}
