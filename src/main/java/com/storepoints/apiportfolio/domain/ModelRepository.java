package com.storepoints.apiportfolio.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Long> {

	Page<Model> findAll(Pageable pageable);

//	City findByNameAndCountryAllIgnoringCase(String name, String country);

	List<Model> findByAdvisorId(String advisorId);
	
	Page<Model> findByAdvisorId(String advisorId, Pageable pageable);	
	
	List<Model> findByName(String name);
	

}