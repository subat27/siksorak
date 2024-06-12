package kr.co.clover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.clover.repository.MemberLocationRepository;

@Service
public class MemberLocationService {
	@Autowired
	private MemberLocationRepository mlRepository;
}
