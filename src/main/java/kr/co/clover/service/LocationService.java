package kr.co.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.clover.entity.Location;
import kr.co.clover.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository lRepository;
	
	public Page<Location> findAll(int page) {
		int pagePerBoardCount = 12;
		Pageable pageable = PageRequest.of(page, pagePerBoardCount, Sort.by(Sort.Direction.ASC, "title"));		
		return lRepository.findAll(pageable);
	}
	
}
