package com.storepoints.apiportfolio.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AdvisorRepository extends CrudRepository<Advisor, Long> {
	
	Page<Advisor> findAll(Pageable pageable);
	
	List<Advisor> findByAdvisorId(String advisorId);
}
