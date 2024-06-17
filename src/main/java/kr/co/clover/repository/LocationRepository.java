package kr.co.clover.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.clover.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, String>{
	Page<Location> findAll(Pageable pageable);
	
	@Query("SELECT l FROM Location l where (l.title LIKE %:title% OR l.addr1 LIKE %:addr1%) AND l.addr1 LIKE %:sigungucode%")
	Page<Location> findByTitleOrAddr1AndSigungucode(@Param("title")String title, @Param("addr1")String addr1, @Param("sigungucode")String sigungucode, Pageable pageable);
	
	@Query("SELECT l FROM Location l where (l.title LIKE %:title% OR l.addr1 LIKE %:addr1%) AND l.addr1 LIKE %:sigungucode% AND l.contenttypeid IN :ids")
	Page<Location> findByTitleOrAddr1AndSigungucodeAndContentTypeId(@Param("title")String title, @Param("addr1")String addr1, @Param("sigungucode")String sigungucode, @Param("ids")List<String> contentTypeId, Pageable pageable);
		
	Page<Location> findByContentidIn(List<Location> locationIdList, Pageable pageable);
}
