package kr.co.clover.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	List<Location> findByAddr1Containing(String keyword);
	List<Location> findByTitleContaining(String keyword);
	
	Page<Location> findAll(Pageable pageable);
}
