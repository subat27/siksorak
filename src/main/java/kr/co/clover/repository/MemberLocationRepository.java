package kr.co.clover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.MemberLocation;

@Repository
public interface MemberLocationRepository extends JpaRepository<MemberLocation, Integer> {

}
