package kr.co.clover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.MemberLocation;

@Repository
public interface MemberLocationRepository extends JpaRepository<MemberLocation, Integer> {

	@Query("SELECT ml.locationId FROM MemberLocation ml where ml.memberId IN :memberId")
	List<String> findLocationIdByMemberId(@Param("memberId") Integer memberId);

	int countByMemberId(Integer memberId);

}
