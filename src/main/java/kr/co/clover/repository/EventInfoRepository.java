package kr.co.clover.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.clover.entity.EventInfo;

public interface EventInfoRepository extends JpaRepository<EventInfo, String>{
	Page<EventInfo> findAll(Pageable pageable);
	
	Page<EventInfo> findByCreatedtime(String createdtime, Pageable pageable);
}
