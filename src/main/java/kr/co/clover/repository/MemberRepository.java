package kr.co.clover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member findByUserid(String userid);

	Member findByUseridAndPassword(String userid, String password);
}
	
