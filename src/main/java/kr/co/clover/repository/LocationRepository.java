package kr.co.clover.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	Page<Location> findAll(Pageable pageable);
	Page<Location> findByTitleContainingOrAddr1Containing(String title, String addr1, Pageable pageable);
	Page<Location> findBySigungucode(Integer sigunguCode, Pageable pageable);
	Page<Location> findByContenttypeidIn(List<String> contenttypeid, Pageable pageable);
}
